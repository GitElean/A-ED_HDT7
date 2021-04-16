/***
 * Universidad del Valle de Guatemala
 * Estructuras de datos
 * Hoja de trabajo #7
 * Abril 2021
 * @Author: Elean Rivas 19062
 * BinaryTreeAssociations class
 */

package traductorArbol;

public class BinaryTreeAssociotions extends BinaryTree<Associations<String, String, String>>{

    public BinaryTreeAssociotions(){
        this.setValue(null);
        this.left = null;
        this.right = null;
    }

    public BinaryTreeAssociotions(Associations<String, String, String> assos){
        this.setValue(assos);
        this.left = null;
        this.right = null;
        this.root = null;
    }
}
