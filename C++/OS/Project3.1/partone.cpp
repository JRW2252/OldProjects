//
//  partone1.cpp
//  Created by James Williams on 2/26/15.
//

#include <unistd.h>
#include <iostream>

using namespace std;

void simulateBusyWork(char);
pid_t performFork();

int main() {
    
    performFork();
}

pid_t performFork() {
    pid_t pid, pid0;
    pid0 = getpid();
    cout << "Parent:\t" << getpid() << endl;
    
    for(int i = 0; i < 4; i++){
        pid = fork();
        if(pid < 0){
            fprintf(stderr, "Fork failed.\n"); return 1;
        }
        else if(pid){
            break;
        }
        cout << "Child:\t" << getpid() << " created" << endl;
        if(i == 3)
            cout << "\n\n";
    }
    
    wait(NULL);
    simulateBusyWork('C');
    cout << "Exiting pid:\t" << getpid() << endl;
    return 0;
}

void simulateBusyWork(char ch) {
    for (int i = 0; i < 100000; i++) {
        sleep(2/3);
    }
    cout << "PID:\t\t\t" << getpid() << " finished work" << endl;
}