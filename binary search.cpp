#include<iostream>
using namespace std;

int binarysearch(int a[],int n, int val)
{
int left=0;
int right=n-1;
    while(left<=right)
    {
   int mid=(left+right)/2;
    if(a[mid]==val)
    return mid;

    else if(a[mid]<val)
        left=mid+1;

    else
        right=mid-1;

    }
    return -1;
}

int main()
{
    int n, a[1000],pass,i,temp,val;
    cout<<"Enter array length: ";
    cin>>n;

    cout<<"Enter array element: ";
    for(i=0; i<n; i++)
    {
        cin>>a[i];
    }

    cout<<"Enter searching value: ";
    cin>>val;

    for(pass=1; pass<n; pass++)
    {
        for(i=0; i<n-pass; i++)
        {
            if(a[i]>a[i+1])
            {
                temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }

        }
    }

    int result=binarysearch(a,n,val);

   if(result==-1)
    cout<<"Element not found.";
    else cout<<" Element found at index: "<<result<<endl;

    return 0;
}

