/* October 23, 2014 - Data Structures Lecture - Recursion */
/*
*
*
* Section 8.2 Problem - 1
*
*/
if the root is NULL
    // The item is not in the tree;
    return NULL;
// Compare the value of target with root->data
if they are equal
    // The target has been found,
    return the data at the root
else if the target is less than root->data
    Return the result of searching the left subtree
else
    Return the result of searching the right subtree
/*
*
*
*/

// left - root - right
inOrder(t) {
    if (t is not empty) {
        inOrder(leftTree(t));
        access the root item of t;
        inOrder(rightTree(t));
    } // if
} // inOrder traversal

// left - right - root
postOrder (t) {
    if (t is not empty) {
        postOrder(leftTree(t));
        postOrder(rightTree(t));
        access the root item of t;
    } // if
} // postOrder traversal

// root - left - right
preOrder (t) {
    if (t is not empty) {
        access the root item of t;
        preOrder (leftTree (t));
        preOrder (rightTree (t));
    } // if
} // preOrder traversal
