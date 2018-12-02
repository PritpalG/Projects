#include <iostream>
#include <fstream>
#include <array>

// This program was created by Pritpal Garcha
// Student Number: 300276049
// COSC 222 Data structures Lab 2

using namespace std;


void swap(int first, int second) {
    int tmp, x = first, y = second;
    tmp = x;
    x = y;
    y = tmp;
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


//This method has a complexity of O(n^2) because
//In the worst case scenario the array length will be searched twice

/* int getDigits(int data[], int Length) {
    int digitsRequired = 1;
    int comparison[Length];
    for(int j=0;j<Length;j++){
        int mod=1;
        comparison[j] = data[j];
        for(int z=0;z<Length;z++){
            if(comparison[j] % (10*mod) == data[z] % (10*mod) ) {
                digitsRequired++;
                break;
            }mod*=10;
        }
        //Garbage collection
        fill(comparison, comparison+Length, 0);
    }
    return digitsRequired;
} */


// This method will execute with a complexity of O(n*logn)
// the outer loop is constant time while the inner loops
// perform simultainous work of sorting then simply checking
// if their are any matching neighbor digits

int getDigits(int data[], int Length) {
    int mod = 1;
    int digitsRequired = 1;
    
    bool end = false;
    
    for(int digits = 0; digits < 9; digits++){
        int myArray[Length];
        mod = mod * 10;
        
        for(int i=0;i<Length; i++){
            int temp = data[i];
            temp = temp % mod;
            myArray[i] = temp;
        }
        
        quickSort(myArray,0,Length/2);
        
        for(int k=0; k<Length; k++){
            
            if(k+1 < Length && myArray[k] == myArray[k+1]) {
                digitsRequired++;
                break;
            }
            if(k+1 == Length){
                end = true;
            }
        }
        if (end) {
            break;
        }
    }
    return digitsRequired;
}


int rFileSize(string fileName){
    ifstream readFromFile;
    readFromFile.open(fileName.c_str(), ios::in);
    int token;
    int counter = 0;
    if(readFromFile.is_open()){
        while(readFromFile >> token){
            counter++;
        }
    }else{
        cout << "Unable to read file.\n";
    }
    readFromFile.close();
    return counter;
}


int main(int argc, char *argv[]){
    /*if(argc !=2){
        cout << "Please enter a.out followed by the file name." << endl;
        return 0;
    } */
    int Length = 0;
    
    
    ifstream inFile;
    //If command line
    if(argc == 2){
        string fileName = argv[1];
        Length = rFileSize(argv[1]);
        inFile.open(fileName);
        if(inFile.fail()){
            cerr<< "In file not working";
        }
    //Else file from project folder
    }else{
        Length = rFileSize("StudentID_List.txt");
        inFile.open("StudentID_List.txt");
        if(inFile.fail()){
            cerr<< "In file not working";
        }
    }
    
    int myArray[Length];

    //Adding each token in file to our array
    int inData;
    int i=0;
    while(inFile >> inData){
        myArray[i] = inData;
        i++;
    }inFile.close();
    
    cout << getDigits(myArray, Length);
    cout << "\n";
    
    return 0;
    
}