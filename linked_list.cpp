#include <iostream>
#include <vector>
#include <string>

using namespace std;

//come to me - kneel down for me - one more time
template <class Object> class Node {
    public:
        Node ( const Object& el = Object(), Node* node = NULL ){

        }
        const Object& getElement();
        Node* getNext();
        void setNext(Node* node);
    private:
        Object element;
        Node* next;
};





int main()
{
    vector<string> msg {"Hello", "C++", "World", "from", "VS Code", "and the C++ extension!"};

    for (const string& word : msg)
    {
        cout << word << " ";
    }
    cout << endl;
}
