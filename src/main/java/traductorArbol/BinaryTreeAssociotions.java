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

    /***
     * Constructor vació
     */
    public BinaryTreeAssociotions(){
        this.setValue(null);
        this.left = null;
        this.right = null;
    }

    /***
     * Constructor con valor establecido
     * @param assos el valor a settear
     */
    public BinaryTreeAssociotions(Associations<String, String, String> assos){
        this.setValue(assos);
        this.left = null;
        this.right = null;
        this.root = null;
    }

    /***
     * Verifica si la palabra esta en el diccionario o si retorna el caracter
     * @param english palabra a analizar
     * @return palabra traducida o palabra dentro de los carácteres
     */
    private String englishToTohers(String english){
        String words = "";
        words = searchWords(this, english);
        if (words.equals("")){
            words="*"+english+"*";
        }
        
        return words;
    }

    /***
     * Busca la palabra in order para dar una traduccion *Solo inglés*
     * @param tree Arbol a recorrer
     * @param english Palabra que se busca
     * @return palabra traducida
     */
    private String searchWords(BinaryTree<Associations<String, String, String>> tree, String english){
        String translation="";
        if(tree!=null) {
            if (tree.val().getEnglish().toLowerCase().equals(english.toLowerCase())){
                translation = "Spanish: "+ (tree.val().getSpanish()) +" French: " +(tree.val().getFrench());
                return  translation;
            }
        }
        
        if(tree.left!=null && translation.equals("")) {
            translation=searchWords(tree.left,english);
        }
        
        if(tree.right!=null && translation.equals("")) {
            translation=searchWords(tree.right,english);
        }

             
   
        return translation;
    }

    /***
     * Guarda las palabras en orden para el arbol
     * @param tree arbol donde se guardan los nodos
     */
    public  void newTranslation(BinaryTree<Associations<String,String, String>> tree) {
        if(this.val()==null && this.isRoot()) {
            this.setValue(tree.val());
        } else if(this.val().getEnglish().compareTo((tree.val().getEnglish()))<0) {
            if(this.right()==null && tree.val()!=null) {
                this.setRight(tree);
            }else{
                ((BinaryTreeAssociotions) this.right).newTranslation(tree);
            }
        }else {

            if(this.left()==null && tree!=null) {
                this.setLeft(tree);
            }else {
                ((BinaryTreeAssociotions) this.left).newTranslation(tree);
            }
        }

    }

    /***
     * Recorre el arbol in order
     */
    public void inOrderAssociation() {
        inOrderAssociations(this);
    }

    /***
     * Recorre el árbol de manera inorder de izquierda a derecha
     * @param tree arbol a reccorer
     */
    private void inOrderAssociations(BinaryTreeAssociotions tree) {
        if (tree == null )
        { return; }

        inOrderAssociations((BinaryTreeAssociotions)tree.left());
        System.out.println("("+tree.val().getEnglish()+","+tree.val().getSpanish()+")"+"("+tree.val().getFrench()+")");
        inOrderAssociations((BinaryTreeAssociotions)tree.right());

    }
}
