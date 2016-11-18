// CS3242 Operating Systems
// Spring 2015
// Project 5: Swapping and Paging, Part 2
// Alex Wardlaw, Ryan Williams, and Ryan Wraggs
// Date: 4/14/2015
// File: parttwo.cpp

#include <iostream>
#include <sstream>      /* stringstream for num to int and int to num */
#include <stdio.h>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time for srand */
#include <unistd.h>     /* usleep */
#include <vector>
#include <iomanip>      /* setw for charToString */

#define MAX_PROCESSES 52            // This will not ever change
#define PROCESS_COUNT 23            // useful when debugging to limit # of procs
#define MIN_DEATH_INTERVAL 20
#define MAX_DEATH_INTERVAL 300
#define MAX_FRAMES 280
#define MAX_PAGES 720
#define SHIFT_INTERVAL 10
#define PRINT_INTERVAL 50          // # of cpu quanta between memory map printouts
#define MAX_QUANTA 400            // # quanta to run before ending simulation.
#define SLEEP_LENGTH 25000 // Used with the usleep()to slow down sim between cycles (makes reading screen in real-time easier!)

using namespace std;

//      Structs         //

//this struct contains all of the info for a process's page info
struct Page
{
    char procName;
    int lifetime;
    string pageName;            //the page name as it appears in memory, ie, "A1"
    int procPageNumber;         //the page number, ie, 0-19
    int location;
    char validBit;
    unsigned char reference;    //unsigned char is 8 bits
};

struct Process
{
    //segments (* * code(2), stack(3), heap(5), sub-p's (1-5) * *)
    char name;
    vector <Page> pages; // 0-1 == code, 2-4 = stack, 5-9 = heap, 10-19 = sub-p's
    int lifetime;
};

//    METHOD HEADERS    //
void PrintMemory();
string NumberToString(int numIn);
int StringToNumber(string strIn);
int FIFO(string pageToAdd);
void LRU(vector <int []> vec);
int SecondChance(string pageToAdd);
void init_mem();
void touch(); // touch random process
bool kill(char p_name);  // aka death: removes p from mem and backing
void print();
void createP(char p_name); // create process (* * code(2), stack(3), heap(5), sub-p's (1-5) * *)
bool removePage(int memPage);   // remove page from mem
bool loadP(Process p); // load process into mem
bool AddProcessToBackingStore(Process p);
void PrintBackingStore();
void setRef(char p_name);
void PrintPageTable();
void IncrementRef();
void get_stats();
void print_stats();
string charToString(unsigned char c);

//      GLOBALS         //
int choice, quanta, locationLastAdded, used_frames, num_pages, num_processes, loaded, unloaded;
char p_names[] = {'@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','m','n','o','p','q','r','s','t','u','v','w','x','y', 'z'};
vector<string> memory;
vector<string> backingStore;
vector<Process> processVec;
vector<unsigned char> referenceBit;


int main(int argc, const char * argv[]) {
    
    srand ((int)time(NULL));     //seed the random number generator.
    string in;
    do{
        printf("\nChoose a page replacement algorithm\n1:\tFIFO\n2:\tLRU\n3:\tSecond Chance\n4:\tExit\n\nUser Input: ");
        cin >> in;
        choice = StringToNumber(in);
        if(choice == 1)
            cout << "You chose: " << choice << " for FIFO" << endl;
        else if(choice == 2)
            cout << "You chose: " << choice << " for LRU" << endl;
        else if(choice == 3)
            cout << "You chose: " << choice << " for Second Chance" << endl;
        else if(choice == 4){
            cout << "You chose: " << choice << endl;
            cout << "\n * * *\tEXIT PROGRAM\t* * *" << endl;
            exit(0);
        }
        else
            cout << "\nInvalid choice. Try again.\n";
    } while(choice != 1 && choice != 2 && choice != 3);
    
    locationLastAdded = 0;
    init_mem();
    
    quanta = 0;
    while (quanta <= MAX_QUANTA)
    {
        if (quanta % PRINT_INTERVAL == 0)
            print();
        //increments reference bit every 10 quanta if choice is LRU
        if (choice == 2 && quanta % SHIFT_INTERVAL == 0)
            IncrementRef();
        
        //touch() touches, creates and kills processes
        touch();
        quanta++;
        usleep(SLEEP_LENGTH);
    }
    
    
}

void PrintMemory()
{
    string sixSpaces = "      ";
    string ruler = "--------++--------||--------++--------||--------++--------||--------++--------||--------++--------||";
    int rowWidth = 100;
    int i = 0;
    
    printf("Memory:\n");
    while (i < MAX_FRAMES)
    {
        string numLine;
        string memLine;
        //creates the row with the numbers with the proper spacing.
        for (int counter = 0; counter < rowWidth / 10; counter++)
        {
            if (i < MAX_FRAMES)
            {
                string str = NumberToString(i + 4);
                if (str.length() == 1)
                    numLine += sixSpaces + "   " + str;
                else if (str.length() == 2)
                    numLine += sixSpaces+ "  " + str;
                else if (str.length() == 3)
                    numLine += sixSpaces + " " + str;
                else if (str.length() == 4)
                    numLine += sixSpaces + str;
            }
            i += 5;
        }
        
        printf("%s\n", numLine.c_str());
        printf("%s\n", ruler.c_str());
        
        //creates the line showing whats in memory.
        for (int counter = 0; counter < rowWidth/2; counter++)
        {
            //add the value if its not an empty string
            if (memory[((i - rowWidth/2) + counter)] != "")
            {
                memLine += memory[((i - (rowWidth/2)) + counter)];
            }
            //else add two spaces if it is an empty string
            else
                memLine += "  ";
            //printf("memline: %s, memory: %s, index: %s\n", memLine.c_str(), memory[((i - rowWidth) + counter)].c_str(), NumberToString(((i - rowWidth) + counter)).c_str());
            
        }
        printf("%s\n", memLine.c_str());
    }
    printf("\n\n");
}

//converts number to string
string NumberToString (int numIn) {
    stringstream ss;
    string s;
    ss << numIn;
    ss >> s;
    return s;
}

int StringToNumber(string strIn){
    stringstream ss;
    int choiceInt = -1;
    ss << strIn;
    ss >> choiceInt;
    if (ss.fail())
        return -1;
    return choiceInt;
}

//returns location added
int FIFO(string pageToAdd){
    //if it finds an empty spot, it adds it there
    for (int i = 0; i < MAX_FRAMES; i++)
    {
        if (memory[i] == "")
        {
            removePage(i);
            memory[i] = pageToAdd;
            return i;
        }
    }
    
    //this ensures the kernal '@' is never removed.
    while (memory[locationLastAdded].find('@') != string::npos)
    {
        locationLastAdded++;
        //necessary to ensure locationlastadded is always valid
        if (locationLastAdded >= MAX_FRAMES)
            locationLastAdded = 0;
    }
    
    //necessary to ensure locationlastadded is always valid
    if (locationLastAdded >= MAX_FRAMES)
        locationLastAdded = 0;
    
    //removes the last added item then increments last added
    removePage(locationLastAdded);
    memory[locationLastAdded++] = pageToAdd;
    return locationLastAdded - 1;
}

int LRU(string pageToAdd){
    int oldestLoc = 0;
    unsigned char oldest = 0;
    oldest--;
    
    //if it finds an empty spot, it adds it there
    for (int i = 0; i < MAX_FRAMES; i++)
    {
        if (memory[i] == "")
        {
            removePage(i);
            memory[i] = pageToAdd;
            return i;
        }
        if (referenceBit[i] < oldest)
        {
            oldest = referenceBit[i];
            oldestLoc = i;
        }
    }
    
    removePage(oldestLoc);
    memory[oldestLoc] = pageToAdd;
    
    return oldestLoc;
}

int SecondChance(string pageToAdd){
    //if it finds an empty spot, it adds it there
    for (int i = 0; i < MAX_FRAMES; i++)
    {
        if (memory[i] == "")
        {
            removePage(i);
            memory[i] = pageToAdd;
            return i;
        }
    }
    
    //this ensures the kernal '@' is never removed.
    while (memory[locationLastAdded].find('@') != string::npos)
    {
        locationLastAdded++;
        //necessary to ensure locationlastadded is always valid
        if (locationLastAdded >= MAX_FRAMES)
            locationLastAdded = 0;
    }
    
    while (true)
    {
        //necessary to ensure locationlastadded is always valid
        if (locationLastAdded >= MAX_FRAMES)
            locationLastAdded = 0;
        //checks to see if reference bit is set, replaces if not
        if (referenceBit[locationLastAdded] == 0)
        {
            //removes the last added item then increments last added
            removePage(locationLastAdded);
            memory[locationLastAdded++] = pageToAdd;
            return locationLastAdded - 1;
        }
        //if reference bit is set, unset it, and increment locationLastAdded
        else
            referenceBit[locationLastAdded++] = 0;
    }
}

void init_mem() {
    int randomSelection = -1;
    
    //create kernel first since i will not have a lifespan
    Process p;
    p.name = '@';
    //kernel will always have 20 pages total
    for (int i = 0; i < 20; i++)
    {
        Page pg;
        pg.location = -1;
        pg.validBit = 'i';
        pg.reference = -1;
        p.pages.push_back(pg);
    }
    
    //use i = 1 to prevent '@' from being used
    for (int i = 1; i < PROCESS_COUNT; i++)
    {
        createP(p_names[i]);
    }
    vector <Process> tmp = processVec;
    
    // filling backing store to max_pages 720
    for(int i = 0; i < MAX_PAGES; i++){
        backingStore.push_back("");
    };
    
    // filling memory to max_frames 280
    for(int i = 0; i < MAX_FRAMES; i++){
        memory.push_back("");
        //set all reference bits to 0
        referenceBit.push_back(0);
    };
    
    do{
        randomSelection = rand()%tmp.size();
        if(!AddProcessToBackingStore(tmp[randomSelection]))
            break;
        //added this to pull all processes into memory
        loadP(tmp[randomSelection]);
        tmp.erase(tmp.begin()+randomSelection);
    } while (tmp.size() > 0);
    
    //kernel must be loaded last to ensure it is in memory
    AddProcessToBackingStore(p);
    loadP(p);
}

void touch() { // touch random process
    
    char toTouch;
    int randP;
    bool touched = false;
    
    //to insure process to be touched is not kernal, '@'
    do{
        randP = rand()%PROCESS_COUNT;
        toTouch = p_names[randP];
    } while(toTouch == '@');
    
    //these two are both covered in this one for loop
    // 1. access code, stack, heap, segments
    // 2. if P's lifetime expired remove from mem and backing ... (needs to be checked every unit of quanta though) ...
    //number 2 will be covered because touch() is called every quanta.
    for (int i = 0; i < processVec.size(); i++)
    {
        if (processVec[i].name == toTouch)
        {
            //this way we know the process exists.
            touched = true;
            loadP(processVec[i]);
            setRef(processVec[i].name);
        }
        if (processVec[i].lifetime <= quanta)
        {
            kill(processVec[i].name);
        }
        
    }
    
    if (!touched)
    {
        createP(toTouch);
        AddProcessToBackingStore(processVec.back());
        loadP(processVec.back());
    }
    
}

bool kill(char p_name){  // aka death: removes p from mem and backing
    int i;
    bool found = false;
    for(i = 0; i < memory.size(); i++){
        // looking for p_name to remove from memory
        if(memory[i].find(p_name) != string::npos){
            memory[i] = "";
            found = true;
        }
    }
    for(i = 0; i < backingStore.size(); i++){
        // looking for p_name to remove from backing store
        if(backingStore[i].find(p_name) != string::npos){
            backingStore[i] = "";
            found = true;
        }
    }
    if(found){
        // remove p_name from processVec
        for(i = 0; i < processVec.size(); i++){
            if(processVec[i].name == p_name)
                processVec.erase(processVec.begin()+i);
        }
    }
    return found;
}

void print(){
    // print mem, page table and backingStore
    
    get_stats();
    print_stats();
    PrintMemory();
    PrintPageTable();
    PrintBackingStore();
}

void createP(char p_name){ // create process (* * code(2), stack(3), heap(5), sub-p's (1-5) * *)
    int i, subs, lifeSpan;
    subs = (rand()%4+1)*2;
    lifeSpan = rand()%280+20;
    Process p;
    p.name = p_name;
    // 1. create information segments for p
    // segments
    for(i = 0; i <= (9+subs); i++){
        Page pg;
        pg.location = -1;
        pg.validBit = 'i';
        pg.reference = -1;
        p.pages.push_back(pg);
    }
    // 2. set lifetime for p randomly between 20 - 300 cycles or units of time
    //need the + quanta part for when a process is created after quanta is greater than 300
    p.lifetime = lifeSpan + quanta;
    // 3. load p into backing store or mem (one or other not sure)
    processVec.push_back(p);
}

//copies a page from memory into backing store.  does not remove from memory
bool removePage(int memPage) {
    //find an empty spot in backing store
    for (int i = 0; i < MAX_PAGES; i++)
    {
        if (backingStore[i] == "")
        {
            backingStore[i] = memory[memPage];
            return true;
        }
    }
    return false;
}

bool loadP(Process p){ // load process into mem
    // if process's segments are not in mem, simulate pg. fault and load them into mem
    for (int i = 0; i < MAX_PAGES; i++)
    {
        if (backingStore[i].find(p.name) != string::npos)
        {
            switch (choice)
            {
                case 2:
                    referenceBit[LRU(backingStore[i])] = 255;
                    backingStore[i] = "";
                    break;
                case 3:
                    referenceBit[SecondChance(backingStore[i])] = 255;
                    backingStore[i] = "";
                    break;
                default:
                    referenceBit[FIFO(backingStore[i])] = 255;
                    backingStore[i] = "";
            }
        }
    }
    return true;
}

//adds a new process in backing store to be added into memory later
bool AddProcessToBackingStore(Process p) {
    for (int i = 0; i < p.pages.size(); i++)
    {
        for (int j = 0; j < MAX_PAGES; j++)
        {
            if (backingStore[j] == "")
            {
                if (i < 2) {
                    backingStore[j] = p.name + NumberToString(0);
                    break;
                } else if (i >= 2 && i < 5) {
                    backingStore[j] = p.name + NumberToString(1);
                    break;
                } else if (i >=5 && i < 10) {
                    backingStore[j] = p.name + NumberToString(2);
                    break;
                } else if (i >= 10 && i < 12) {
                    backingStore[j] = p.name + NumberToString(3);
                    break;
                } else if (i >= 12 && i < 14){
                    backingStore[j] = p.name + NumberToString(4);
                    break;
                } else if (i >= 14 && i < 16) {
                    backingStore[j] = p.name + NumberToString(5);
                    break;
                } else if (i >= 16 && i < 18) {
                    backingStore[j] = p.name + NumberToString(6);
                    break;
                } else if (i >= 18 && i < 20) {
                    backingStore[j] = p.name + NumberToString(7);
                    break;
                } else if (i == 719) {
                    return false;
                }
            }
        }
    }
    return true;
}

void PrintBackingStore() {
    string sixSpaces = "      ";
    string ruler = "--------++--------||--------++--------||--------++--------||--------++--------||--------++--------||";
    int rowWidth = 100;
    int i = 0;
    
    printf("Backing Store:\n");
    while (i < MAX_PAGES)
    {
        string numLine;
        string memLine;
        //creates the row with the numbers with the proper spacing.
        for (int counter = 0; counter < rowWidth / 10; counter++)
        {
            if (i < MAX_PAGES)
            {
                string str = NumberToString(i + 4);
                if (str.length() == 1)
                    numLine += sixSpaces + "   " + str;
                else if (str.length() == 2)
                    numLine += sixSpaces+ "  " + str;
                else if (str.length() == 3)
                    numLine += sixSpaces + " " + str;
                else if (str.length() == 4)
                    numLine += sixSpaces + str;
            }
            i += 5;
        }
        
        printf("%s\n", numLine.c_str());
        printf("%s\n", ruler.c_str());
        
        //creates the line showing whats in memory.
        for (int counter = 0; counter < rowWidth/2; counter++)
        {
            //add the value if its not an empty string
            if (backingStore[((i - rowWidth/2) + counter)] != "")
                memLine += backingStore[((i - rowWidth/2) + counter)];
            //else add two spaces if it is an empty string
            else
                memLine += "  ";
        }
        printf("%s\n", memLine.c_str());
    }
    printf("\n\n");
}

//decrements reference bit of the particular process
void setRef(char p_name) {
    for (int i = 0; i < MAX_FRAMES; i++)
    {
        if (memory[i].find(p_name) != string::npos)
            referenceBit[i]--;
    }
}

void PrintPageTable()
{
    //first, create a vector of pages which has all the needed data:
    vector<Page> allPageVec;
    
    //use i = 1 to skip over '@'
    for (int i = 1; i < PROCESS_COUNT; i++)
    {
        for (int j = 0; j < MAX_FRAMES; j++)
        {
            if (memory[j].find(p_names[i]) != string::npos)
            {
                Page p;
                p.procName = p_names[i];
                p.pageName = memory[j];
                p.validBit = 'v';
                p.location = j;
                p.reference = referenceBit[j];
                allPageVec.push_back(p);
            }
        }
        
        for (int j = 0; j < MAX_PAGES; j++)
        {
            if (backingStore[j].find(p_names[i]) != string::npos)
            {
                Page p;
                p.procName = p_names[i];
                p.pageName = backingStore[j];
                p.validBit = 'i';
                p.location = 0;
                p.reference = 0;
                allPageVec.push_back(p);
            }
        }
    }
    
    int rowWidth = 11;
    int letter = 1;
    
    while (letter < PROCESS_COUNT)
    {
        for (int count = 0; count < rowWidth; count++)
        {
            printf("%*c    ", 6, p_names[letter]);
            letter++;
        }
        
        for (int rowCount = 0; rowCount < 20; rowCount++)
        {
            letter -= rowWidth;
            printf("\n");
            for (int count = 0; count < rowWidth; count++)
            {
                if (rowCount < 2)
                {
                    string name = p_names[letter] + NumberToString(0);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("0%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("0%d --- ---|", rowCount);
                }
                else if (rowCount > 1 && rowCount <= 4)
                {
                    string name = p_names[letter] + NumberToString(1);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("0%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("0%d --- ---|", rowCount);                }
                else if (rowCount > 4 && rowCount <= 9)
                {
                    string name = p_names[letter] + NumberToString(2);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("0%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("0%d --- ---|", rowCount);
                }
                else if (rowCount > 9 && rowCount <= 11)
                {
                    string name = p_names[letter] + NumberToString(3);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("%d --- ---|", rowCount);
                }
                else if (rowCount > 11 && rowCount <=13)
                {
                    string name = p_names[letter] + NumberToString(4);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("%d --- ---|", rowCount);
                }
                else if (rowCount > 13 && rowCount <= 15)
                {
                    string name = p_names[letter] + NumberToString(5);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("%d --- ---|", rowCount);
                }
                else if (rowCount > 15 && rowCount <= 17)
                {
                    string name = p_names[letter] + NumberToString(6);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("%d --- ---|", rowCount);
                }
                else if (rowCount > 17)
                {
                    string name = p_names[letter] + NumberToString(7);
                    bool found = false;
                    for (int j = 0; j < allPageVec.size(); j++)
                    {
                        if (allPageVec[j].pageName == name) {
                            string loc = NumberToString(allPageVec[j].location);
                            while(loc.length() < 3)
                                loc = "0" + loc;
                            string ref = charToString(allPageVec[j].reference);
                            printf("%d %s %c%s|", rowCount, loc.c_str(), allPageVec[j].validBit, ref.c_str());
                            allPageVec.erase(allPageVec.begin() + j);
                            found = true;
                            break;
                        }
                        
                    }
                    if (!found)
                        printf("%d --- ---|", rowCount);
                }
                letter++;
            }
        }
        printf("\n\n");
    }
}

string charToString(unsigned char c)
{
    stringstream ss;
    string s;
    ss << setw(2) << setfill('0') << hex << (int) c;
    ss >> s;
    return s;
}


//actually decrements the reference value
void IncrementRef() {
    for (int i = 0; i < MAX_FRAMES; i++)
    {
        referenceBit[i] = referenceBit[i] >> 1;
    }
}

void get_stats() {
    used_frames = 0; num_pages = 0; num_processes = 0; loaded = 0; unloaded = 0;
    vector<Process>tmp = processVec;
    
    for(int i = 0; i < backingStore.size(); i++) {
        if(backingStore[i] != "")
            ++num_pages;
        for(int j = 0; j < tmp.size(); j++){
            if(tmp[j].name  == backingStore[i][0]){
                tmp.erase(tmp.begin()+j);
            }
        }
    }
    
    for(int i = 0; i < memory.size(); i++) {
        if(memory[i] != "")
            ++used_frames;
    }
    
    loaded = (int)tmp.size();
    unloaded = (int)processVec.size() - loaded;
}

void print_stats(){
//     GLOBALS
//    int choice, quanta, locationLastAdded, mem_used, mem_free, num_frames, num_pages;

    get_stats();
    printf("\n\t\tQUANTA ELAPSED:\t%d\n",quanta);
    
    printf("\t\tFRAMES:%*df\tUSED FRAMES:%*df (%.1f%%)\tFREE FRAMES:%*df (%.1f%%)\n",9,MAX_FRAMES,5,used_frames, ((used_frames*1.0)/(MAX_FRAMES*1.0))*100.0,5,MAX_FRAMES-used_frames,(MAX_FRAMES*1.0)/((MAX_FRAMES-used_frames)*1.0));
    
    printf("\t\tSWAP SPACE:%*dp\tTOTAL PAGES:%*dp (%.1f%%)\tLOADED PAGES:%*dp (%.1f%%)\n\t\tUNLOADED:%*dp\t(%.1f%%)\t\t\t\tFREE PAGES:%*dp (%.1f%%)\n", 5, MAX_PAGES, 5,loaded+unloaded, (((loaded+unloaded)*1.0)/(MAX_PAGES*1.0))*100.0, 4, loaded,((loaded*1.0)/(MAX_PAGES*1.0))*100.0, 7, unloaded,((unloaded*1.0)/(MAX_PAGES*1.0))*100.0 ,6, MAX_PAGES - num_pages,(((MAX_PAGES-num_pages)*1.0)/(MAX_PAGES*1.0))*100.0);
    
    printf("\t\tPROCESSES:%*d\tLOADED:%*d\tUNLOADED:%*d\tDEAD:%*d\n\n",6,PROCESS_COUNT,5,loaded,5,unloaded,5,PROCESS_COUNT-(int)processVec.size());
}
