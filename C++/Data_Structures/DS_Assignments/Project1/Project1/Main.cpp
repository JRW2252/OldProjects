#include <iostream>
#include <string>

using namespace std; 

double gradeAvg(int, int);

int main(void){
	
	cout << "Enter the number of students: ";
	int nStudents, *p, sum = 0; 
	cin >> nStudents; 
	p = new int[nStudents];

	cout << "\nEnter in the grade of student ";
	for (int i = 0; i < nStudents; i++)
	{
		cout << "Enter the grade for student # " << i+1 << ": ";
		cin >> p[i];
		sum += p[i];
		cout << endl;
	}

	cout << "\nClass grade average: ";
	cout << gradeAvg(sum, nStudents) << endl;
	system("pause");
}

double gradeAvg(int sm, int num){
	return sm / num; 
}