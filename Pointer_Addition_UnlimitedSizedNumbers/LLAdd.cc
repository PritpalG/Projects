//
//  main.cpp
//  LLAddition
//
//  Created by Paul Garcha on 2018-10-21.
//  Copyright © 2018 Paul Garcha. All rights reserved.
//
// OKSUN6 CREDENTIALS
// NAME: Pritpal Garcha
// STUDENT#: 300276049
// USERNAME: pgarcha


#include <iostream>
#include <fstream>


//Individual node class
class Node{
public:
    Node* next;
    int digit;
    char dec;
    
public: Node(int digit){
    this->digit=digit;
}
    
    void setDigit(int digit){
        this->digit = digit;
    }
    
    void setChar(char c){
        this->dec = c;
    }
    
    char getDec(){
        return this->dec;
    }
    
};


using namespace std;


class LinkedList{
public:
    //Constructor from LL class
    LinkedList(){
        this->head = NULL;
    }
    
    //Adds additional node to back of LL
    void addBack(Node* n){
        if(head == NULL){
            head = n;
        }else{
            Node* temp = head;
            while(temp){
                if(temp->next == NULL){
                    temp->next = n;
                    break;
                }
                temp=temp->next;
            }
        }
    }
    
    
    //Adds node to front of LL
    void add(Node* n){
        n->next = head;
        head = n;
    }
    
    //Displays contents of LL to console
    void print(){
        Node* temp = head;
        while(temp){
            if(temp->digit >  23 || temp->getDec() == '.'){
                cout << '.';
                temp = temp->next;
                continue;
            }
            cout << temp->digit;
            temp = temp->next;
        }cout << endl;
    }
    
    void setHead(Node* value){
        head = value;
    }
    
    Node* getHead(){
        return head;
    }
    
    //private:
    Node* head;
    
    //Prototypes
    ~LinkedList();
    
};



//Destructor from LL class
LinkedList::~LinkedList(){
    cout << "LIST DELETED\n";
}


//Returns Length of LL
int llSize(LinkedList* data){
    int counter = 0;
    Node* temp = data->head;
    while(temp){
        counter++;
        temp = temp->next;
    }
    return counter;
}


int llPostDecSize(LinkedList* data){
    int res=0;
    bool start = false;
    Node* temp = data->head;
    while(temp){
        if(start){
            res++;
        }
        if(temp->getDec()=='.'){
            start = true;
        }
        temp = temp->next;
    }
    return res;
}


//Outputs Polynomial data
void sendP(LinkedList* result){
    //Declaring output file to save results
    ofstream ofFile;
    ofFile.open("output.txt");
    //Ensuring communication with file is established
    if(ofFile.fail()){
        cerr<< "Out file not working";
    }
    Node* temp = result->head;
    while(temp){
        ofFile << temp->digit << endl;
        temp = temp->next;
    }
}


//Checks if there are decimals to deal with
bool isThereDec(LinkedList* data){
    Node* temp = data->head;
    while(temp){
        if(temp->getDec() == '.'){
            return true;
        }else{
            temp = temp->next;
        }
    }
    return false;
}


LinkedList* whichHasSecondDec(LinkedList* first,LinkedList* second){
    int firstCount = 0;
    int secondCount = 0;
    Node* fTemp = first->head;
    Node* sTemp = second->head;
    while(fTemp){
        firstCount++;
        fTemp = fTemp->next;
    }
    while(sTemp){
        secondCount++;
        sTemp = sTemp->next;
    }
    return firstCount > secondCount ? first : second;
}


//Build polynomial starting at largest digit
LinkedList* buildPForward(string fileName){
    LinkedList* result = new LinkedList();
    ifstream myFile;
    myFile.open(fileName);
    if(myFile.fail()){
        cerr<< fileName << " file not working\n";
    }
    int digit=0;
    char checkForDec = '0';
    while(myFile >> checkForDec){
        if(checkForDec=='.'){
            Node* populate = new Node(0);
            populate->setChar(checkForDec);
            result->addBack(populate);
        }else{
            digit = checkForDec - '0';
            Node* populate = new Node(digit);
            result->addBack(populate);
        }
    }
    return result;
}


//Build polynomial starting at smallest digit
LinkedList* buildP(string fileName){
    LinkedList* result = new LinkedList();
    ifstream myFile;
    myFile.open(fileName);
    if(myFile.fail()){
        cerr<< fileName << " file not working\n";
    }
    int digit=0;
    char checkForDec = '0';
    
    while(myFile >> checkForDec){
        if(checkForDec=='.'){
            Node* populate = new Node(0);
            populate->setChar(checkForDec);
            result->add(populate);
        }else{
            digit = checkForDec - '0';
            Node* populate = new Node(digit);
            result->add(populate);
        }
    }
    return result;
}


//Sums two polynomial function here
LinkedList* sumP(LinkedList* first, LinkedList* second){
    LinkedList* result = new LinkedList();
    
    //Checking for decimals
    bool isFirstDec = isThereDec(first);
    bool isSecondDec = isThereDec(second);

    //Just normal non decimal addition
    if(!isFirstDec && !isSecondDec){
        bool carryOver = false;
        while(first->head || second->head){
            //Second file is longer
            if(first->head == NULL){
                if(carryOver){
                    result->add(new Node(second->head->digit + 1));
                    carryOver = false;
                    second->head = second->head->next;
                    continue;
                }else{
                    result->add(new Node(second->head->digit));
                    second->head = second->head->next;
                    continue;
                }
            }
            //First file is longer
            if(second->head == NULL){
                if(carryOver){
                    result->add(new Node(first->head->digit + 1));
                    carryOver = false;
                    first->head = first->head->next;
                    continue;
                }else{
                    result->add(new Node(first->head->digit));
                    first->head = first->head->next;
                    continue;
                }
            }
            //Addition process - accounts for carryover
            int newDigit = 0;
            if(carryOver){
                newDigit = first->head->digit + second->head->digit + 1;
                carryOver = false;
            }else{
                newDigit = first->head->digit + second->head->digit;
            }
            if(newDigit > 9){
                carryOver = true;
                newDigit = newDigit-10;
                result->add(new Node(newDigit));
            }else{
                result->add(new Node(newDigit));
            }
            //Advance the pointers
            first->head = first->head->next;
            second->head = second->head->next;
        }
        return result;
    }
    //If first has dec but not second 
    if(isFirstDec && !isSecondDec){
        
        second->add(new Node(24));
        second->head->setChar('.');
        second->add(new Node(0));
        isSecondDec = true;
    }
    //If second has dec but not first
    if(!isFirstDec && isSecondDec){
        first->add(new Node(24));
        first->head->setChar('.');
        first->add(new Node(0));
        isFirstDec = true;
    }
    //If both have decimals
    if(isFirstDec && isSecondDec){
        if(llPostDecSize(first) == llPostDecSize(second)){
            if(llSize(first) < llSize(second)){
                while(llSize(first)<llSize(second)){
                    first->add(new Node(0));
                }
            }else if(llSize(second)<llSize(first)){
                while(llSize(second)<llSize(first)){
                    second->add(new Node(0));
                }
            }
        }
        if(llPostDecSize(first) > llPostDecSize(second)){
            while(llPostDecSize(first) > llPostDecSize(second)){
                second->addBack(new Node(0));
            }
            if(llSize(first) < llSize(second)){
                while(llSize(first)<llSize(second)){
                    first->add(new Node(0));
                }
            }else if(llSize(second)<llSize(first)){
                while(llSize(second)<llSize(first)){
                    second->add(new Node(0));
                }
            }
        }
        if(llPostDecSize(first) < llPostDecSize(second)){
            while(llPostDecSize(first) < llPostDecSize(second)){
                first->addBack(new Node(0));
            }
            if(llSize(first) < llSize(second)){
                while(llSize(first)<llSize(second)){
                    first->add(new Node(0));
                }
            }else if(llSize(second)<llSize(first)){
                while(llSize(second)<llSize(first)){
                    second->add(new Node(0));
                }
            }
        }
        bool carryOver = false;
        while(first->head || second->head){
            //Second file is longer
            if(first->head == NULL){
                if(carryOver){
                    result->add(new Node(second->head->digit + 1));
                    carryOver = false;
                    second->head = second->head->next;
                    continue;
                }else{
                    result->add(new Node(second->head->digit));
                    second->head = second->head->next;
                    continue;
                }
            }
            //First file is longer
            if(second->head == NULL){
                if(carryOver){
                    result->add(new Node(first->head->digit + 1));
                    carryOver = false;
                    first->head = first->head->next;
                    continue;
                }else{
                    result->add(new Node(first->head->digit));
                    first->head = first->head->next;
                    continue;
                }
            }
            //Deals with LL's decimal
            if(whichHasSecondDec(first,second)->getHead()->getDec() == '.'){
                result->add(new Node(24));
                first->head = first->head->next;
                second->head = second->head->next;
                continue;
            }
            //Addition process - accounts for carryover
            int newDigit = 0;
            if(carryOver){
                newDigit = first->head->digit + second->head->digit + 1;
                carryOver = false;
            }else{
                newDigit = first->head->digit + second->head->digit;
            }
            if(newDigit > 9){
                carryOver = true;
                newDigit = newDigit-10;
                result->add(new Node(newDigit));
            }else{
                result->add(new Node(newDigit));
            }
            //Advance the pointers
            first->head = first->head->next;
            second->head = second->head->next;
        }
        return result;
    }
    return result;
}


int main(int argc, const char * argv[]) {

    //Reversed numbers for computation
    LinkedList* first = buildP("p1.txt");
    LinkedList* second = buildP("p2.txt");
    
    //Forwards number for printing out
    LinkedList* firstForward = buildPForward("p1.txt");
    LinkedList* secondForward = buildPForward("p2.txt");
    
    //Prints numbers then displays their sum
    firstForward->print();
    cout << "+" << endl;
    secondForward->print();
    cout << "--------------" << endl;
    sumP(first, second)->print();
    cout << endl << endl;
    
    
    return 0;
}
