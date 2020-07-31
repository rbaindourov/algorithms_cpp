#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;

//come to me - kneel down for me - one more time - c++11
template <class Object> class List;

class BadIterator : public logic_error {
    public:
        BadIterator( const string& msg = "") : logic_error( msg.c_str() ){}
};

template <class Object> class Node {
    public:
        Node ( const Object& el = Object(), Node* node = NULL ){
            element = el;
            next = node;
        }

        const Object& getElement(){
            return element;
        }

        Node* getNext(){
            return next;
        }

        void setNext(Node* node){
            next = node;
        }
    private:
        Object element;
        Node* next;
};


template <class Object> class Iterator{
    public:
        Iterator() : current( NULL ) {};
        bool isValid() const { return ( current != NULL ); };
        void advance(){
            if(isValid())
                current = current->getNext();
        };
        const Object& retrieve() const{
            if(!isValid()) throw BadIterator();
            return ( current->getElement() );
        };
    private:
        Node<Object>* current;
        Iterator ( Node<Object> *node ) : current( node ) {}
        friend class List<Object>;

};


template <class Object> class List{
    public:
        List();
        List( const List& rhs );
        ~List() {
            makeEmpty();
            delete head;
        };

        bool isEmpty() const;
        void makeEmpty(){
            while( !isEmpty() ){
                remove(first().retrieve());
            }
        };
        Iterator<Object> zeroth() const {
            return Iterator<Object>( head );
        }
        Iterator<Object> first() const;
        Iterator<Object> findPrevious( const Object& data ) const;
        const List operator = ( const List& rhs );
        void remove( const Object& data ){

        };
        void insert( const Object& data ){

        };

        void insert( const Object& data, Iterator<Object> iter ){
            
        };

    private:
        Node<Object> *head;

        
};


//we are one
int main()
{


    
    vector<string> msg {"Hello", "C++", "World", "from", "VS Code", "and the C++ extension!"};

    for (const string& word : msg)
    {
        cout << word << " ";
    }
    cout << endl;
}
