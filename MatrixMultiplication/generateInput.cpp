#include <iostream>
#include <ctime>
#include <cstdio>
#include <cstdlib>
using namespace std;

int main()
{


	srand(time(0));

	int m = 100;

	int n = 100;

	int p = 80;


	for(int i=0;i<m;i++)
	{
		cout<<"A";
		for(int j=0;j<n;j++)
		{
			cout<<","<<rand();

		}
		cout<<endl;

	}

for(int i=0;i<n;i++)
	{
		cout<<"B";
		for(int j=0;j<p;j++)
		{
			cout<<","<<rand();

		}

		cout<<endl;

	}


	return 0;
}