#include<iostream>
using namespace std;
int main()
{
    int n;
    cout<<"Enter array length number:";
    cin>>n;

    int a[n],temp;

    cout<<"Enter element:";

    for(int i=0;i<n;i++)
    {
        cin>>a[i];
       // cout<<a[i]<<" ";
    }

    for(int pass=1;pass<=n-1;pass++)
    {
        for(int i=0;i<n-pass;i++)
        {

            if(a[i]>a[i+1]){
                temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }

        cout<<"After pass "<<pass<<":";
        for(int j=0;j<n;j++)
        {

            cout<<a[j]<<" ";
        }
        cout<<endl;
    }


    cout<<"Final sorted list:";

    for(int i=0;i<n;i++)
    {
        cout<<a[i]<<" ";
    }

}

