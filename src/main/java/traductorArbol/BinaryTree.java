/***
 * Universidad del Valle de Guatemala
 * Estructuras de datos
 * Hoja de trabajo #7
 * Abril 2021
 * @Author: Elean Rivas 19062
 * BinaryTree class
 */

package traductorArbol;

public class BinaryTree<R> {

    //Ejemplo tomado del libro de Java Structures


    protected R value;
    protected BinaryTree<R> root;
    protected BinaryTree<R> left, right;

    /***
     * Constructor vacío
     */
    public BinaryTree(){
        value = null;
        root = null;
        left = right = this;
    }


    /***
     * retorna un arbol referenciando un valor
     * @param val valor a referenciar
     */
    public BinaryTree(R val){
        value = val;
    }

    /***
     * Instancia el nodo padre
     * @return nodo padre
     */
    public BinaryTree<R> root(){
        return root;
    }

    /***
     * Instancia el nodo hijo de la izquierda
     * @return nodo izquierdo
     */
    public BinaryTree<R> left(){
        return left;
    }

    /***
     * instancia el nodo hijo de la derecha
     * @return nodo derecho
     */
    public BinaryTree<R> right(){
        return right;
    }

    /***
     * Referencia al nodo padre
     * @param newRoot el nodo padre
     */
    protected void setRoot(BinaryTree<R> newRoot)
    // post: re-parents this node to parent reference, or null
    {
        if (newRoot!=null) {
            root = newRoot;
        }
    }

    /***
     * Referencia el nodo hijo derecho
     * @param newRight nodo hijo derecho
     */
    public void setRight(BinaryTree<R> newRight){
        if (newRight != null){
            right = newRight;
            right.setRoot(this);
        }
    }

    /***
     * Referencia el nodo hijo izquierdo
     * @param newLeft nodo hijo izquierdo
     */
    public void setLeft(BinaryTree<R> newLeft){
        if (newLeft != null){
            right = newLeft;
            right.setRoot(this);
        }
    }

    /***
     * Orden del padre
     */
    public void inOrder() {
        inOrder(root);
    }

    /***
     * orden del arbol, padres e hijos
     * @param tree arbol a referenciar
     */
    private void inOrder(BinaryTree<R> tree) {
        if (tree == null)
        { return; }
        inOrder(tree.left);
        inOrder(tree.right);
    }

    /***
     * Verifica si es el hijo izquierdo del padre
     * @return
     */
    public boolean isLeftChild() {
        if(root==null) {
            return false;
        }else if(root.left()==this){
            return true;
        }else {
            return false;
        }
    }

    /***
     * Verifica si es el hijo derecho del padre
     * @return
     */
    public boolean isRightChild() {
        if(root==null) {
            return false;
        }else if(root.right()==this){
            return true;
        }else {
            return false;
        }
    }

    /***
     * Verifica si tiene hijos
     * @return
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }

    /***
     * Verfica si es padre
     * @return
     */
    public boolean isRoot() {
        return root == null;
    }


    public R val()
    {
        return value;
    }

    public void setValue(R val)
     {
        value = val;
    }

    public boolean hasLeftChild() {
        if(left==null) {
            return false;
        }else{
            return true;
        }
    }
    public boolean hasRightChild() {
        if(right==null) {
            return false;
        }else{
            return true;
        }
    }

}
