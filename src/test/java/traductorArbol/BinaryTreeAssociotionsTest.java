package traductorArbol;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeAssociotionsTest {
    BinaryTreeAssociotions bnt = new BinaryTreeAssociotions();

    @Test
    void englishToTohers() {
        assertEquals("*word*",bnt.englishToTohers("*word*"));
    }


    @Test
    void inOrderAssociation() {

            inOrderAssociations(this.bnt);

    }

    private void inOrderAssociations(BinaryTreeAssociotions tree) {
        if (tree == null )
        { return; }

        inOrderAssociations((BinaryTreeAssociotions)tree.left());
        System.out.println("("+tree.val().getEnglish()+","+tree.val().getSpanish()+")"+"("+tree.val().getFrench()+")");
        inOrderAssociations((BinaryTreeAssociotions)tree.right());

    }
}