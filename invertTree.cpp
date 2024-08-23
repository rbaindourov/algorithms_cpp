#include <iostream>
#include <string>
#include <vector>
using namespace std;


struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class BinaryTree {

public:

    TreeNode* root;

    BinaryTree(): root(nullptr) {}

    void insertNode(int val){
        this->root = this->recursiveInsert(this->root, val);
    }


    void printTree(){        
        cout<<this->recursivePrint(this->root)<<endl;
    }

    TreeNode* invertTree(TreeNode* node) {
        
        if( node == nullptr ) return nullptr;

        TreeNode* right;
        TreeNode* left;

        left = this->invertTree(node->left);
        right =this->invertTree(node->right);
        
        return node;
        
    }

    string toString(){
        return this->recursivePrint(this->root);
    }

private:
    TreeNode* recursiveInsert(TreeNode* node, int val){

        if( node == nullptr ) return new TreeNode(val);

        if( val < node->val )
            node->left = this->recursiveInsert(node->left, val);
        if ( val > node->val )
            node->right =  this->recursiveInsert(node->right, val);
        
        return node;
    }

    string recursivePrint(TreeNode* node){        
        if( node == nullptr ) return "";
        return to_string(node->val) + " " + this->recursivePrint(node->left) + " " + this->recursivePrint(node->right);
    }

};




int main( int argc, char* argv[]){

    vector<int> tree = {4,2,7,1,3,6,9};
    BinaryTree* btree =  new BinaryTree();
    for( int node:tree){
        cout<<node<<endl;
        btree->insertNode( node );        
    }
    btree->printTree();
    //cout<<"Hello Binary Trees"<<endl<<btree<<endl;

}

