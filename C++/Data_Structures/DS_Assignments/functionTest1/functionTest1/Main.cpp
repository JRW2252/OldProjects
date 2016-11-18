#include <iostream>

using namespace std;

void runs(int); // function prototype

int main(){
	runs(3); // call the runs function
	cout << "Enter the number of runs you completed this week: " << endl;
	int numRuns;
	cin >> numRuns;
	runs(numRuns);
	cout << "Finished. Yay!!!";
	
	cin.get();
	cin.get();

	return 0;
}

void runs(int n)
{
	for (int i = 0; i < n; i++) {
		cout << "You did " << i << "runs this week. Ah, ah, ah..." << endl;
	}
}