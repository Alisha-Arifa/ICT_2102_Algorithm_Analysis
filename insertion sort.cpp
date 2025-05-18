#include<iostream>
using namespace std;

int main()
{
    int n,i,j,temp;
    cout<<"Enter array length: ";
    cin>>n;


    int arr[n];
    cout<<"Enter the array elements: ";
    for(i=0;i<n;i++)
    {
        cin>>arr[i];
    }

    for(i=1;i<n;i++)
    {
        for(j=i;j>0;j--)
        {
            if(arr[j]<arr[j-1])
            {
               temp=arr[j];
               arr[j]=arr[j-1];
               arr[j-1]=temp;
            }
        }
    }

    cout<<"Show the sorted elements after Insertion Sort: ";
    for(i=0;i<n;i++)
    {
        cout<<arr[i]<<" ";
    }

}
