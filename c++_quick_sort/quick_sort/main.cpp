//
//  main.cpp
//  quick_sort
//
//  Created by Paul Garcha on 2018-09-11.
//  Copyright © 2018 Paul Garcha. All rights reserved.
//
//  !!!! Add array population from file

#include <iostream>
#include <fstream>
using namespace std;

void quickSort(int arr[], int left, int right); // <- "Prototype"

int main(int argc, const char * argv[]) {
    int myArray [20] = {};
    
    //Declaring file to populate array
    ifstream inFile;
    inFile.open("input.txt");
    
    //Ensuring communication with file is established
    if(inFile.fail()){
        cerr<< "In file not working";
    }

    //Adding each token in file to our array
    int i=0;
    int inData;
    while(inFile >> inData){
        myArray[i] = inData;
        i++;
    }inFile.close();
    
    //Printing unsorted to console
    cout<<"Unsorted: ";
    for(int i=0; i<20; i++){
        cout << myArray[i];
        cout << " ";
    }cout<< "\n\n";
    
    //Calls sorting fucntion
    quickSort(myArray, 0, sizeof(myArray)/sizeof(myArray[0])-1);
    
    
    //Declaring output file to save results
    ofstream ofFile;
    ofFile.open("output.txt");
    
    //Ensuring communication with file is established
    if(ofFile.fail()){
        cerr<< "Out file not working";
    }
    
    //Adding each sorted token to our file
    int bound=sizeof(myArray)/sizeof(myArray[0]);
    for(int i=0; i<bound; i++){
        ofFile << myArray[i];
        ofFile << " ";
    }
    
    //Printing sorted to console
    cout << "Sorted: ";
    for(int i=0; i<20; i++){
        cout << myArray[i];
        cout << " ";
    }cout<< "\n\n";
    
    return 0;
}


void quickSort(int arr[], int left, int right) {
    int i = left, j = right;
    int pivot = arr[(left + right) / 2];
    
    //Searching element larger than pivot
    while(i<=j){
        //Search start to pivot for element smaller than pivot
        while(arr[i] < pivot){
            i++;
        }
        //Search end to pivot for element larger than pivot
        while(arr[j] > pivot)
            j--;
        //Once found, elements are swapped
        if(i<=j){
            swap(arr[i],arr[j]);
            i++;
            j--;
        }
    };
    
    //Recursion
    if(left < j)
        quickSort(arr, left, j);
    if(i<right)
        quickSort(arr,i,right);
}


//Simple swap function
void swap(int first, int second) {
    int tmp, x = first, y = second;
    tmp = x;
    x = y;
    y = tmp;
}


