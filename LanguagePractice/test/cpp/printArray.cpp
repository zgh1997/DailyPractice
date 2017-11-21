#include<iostream>
using namespace std;

template<class T,int N>
void PrintValues( T (&ia)[N])
{
    for (int i = 0; i != N; i++)
    {
        cout << ia[i] << endl;
    }
}

int main()
{
    char j[2] = { 'a', 'b' };
    PrintValues(j);
    return 0;
}
