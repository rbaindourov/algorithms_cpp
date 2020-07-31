#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;

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
        const Object& getElement(){ return element; }
        bool nextIsNull( ) const { return ( next == NULL); }
        Node* getNext(){  return next;   }
        void setNext(Node* node){  next = node; }
    private:
        Object element;
        Node* next;
};

template <class Object> class Iterator{
    public:
        Iterator() : current( NULL ) {};
        bool isValid() const { return ( current != NULL ); };
        void advance(){  if(isValid()) current = current->getNext();  };
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
        List(){
            head = new Node<Object>;
        };
        List( const List& rhs );
        ~List() {
            makeEmpty();
            delete head;
        };

        bool isEmpty() const {
            return ( head->nextIsNull() );
        } 
        void makeEmpty(){
            while( !isEmpty() ){
                remove(first().retrieve());
            }
        };
        

        Iterator<Object> zeroth() const {
            return Iterator<Object>( head );
        }

        Iterator<Object> first() const{
            return Iterator<Object>( head->getNext() );
        };

        Iterator<Object> findPrevious( const Object& data ) const{
            Node<Object>* node = head;
            while ( node->getNext() != NULL && node->getNext()->getElement() != data )
                node = node->getNext();
            
            if ( node->getNext() == NULL )
                node = NULL;
            
            return Iterator<Object>(node);
        }

        const List operator = ( const List& rhs );
        void remove( const Object& data ){
                Iterator<Object> iter = findPrevious( data );
        };
        void insert( const Object& data ){
            Node<Object>* newnode = new Node<Object>( data, head->getNext() );
            head->setNext(newnode );

        };

        void insert( const Object& data, Iterator<Object> iter ){




        };

    private:
        Node<Object> *head;

        
};


//we are one
int main()
{
    List<string>* llstr = new List<string>();
    vector<string> msg {"Hello", "C++", "World", "from", "VS Code", "and the C++ extension!"};
    for (const string& word : msg) llstr->insert(word);        
    string value = (llstr->first().retrieve());    
    cout<<value;
    std::cout << endl;
}
