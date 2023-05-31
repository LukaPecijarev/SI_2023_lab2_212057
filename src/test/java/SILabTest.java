import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class SILabTest {
    @Test
    public void BrunchTest(){
        RuntimeException exept = assertThrows(RuntimeException.class,() -> SILab2.function(null,null));
        assertEquals("Mandatory information missing!",exept.getMessage());
        //10->20->230   
        LinkedList<User> list = new LinkedList<>();
        list.add(new User("Luka","testproba","luka@gmail.com"));
        assertFalse(SILab2.function(new User(null,"luka pass!","lukapece"),list));
        //10->30->40->50->140->160->170->220->230
        assertFalse(SILab2.function(new User("luka","peceluka","blank@gmail.com"),list));
        //10->30->50->60->70.1->70.2->80->90->110->70.3->70.2->130->140->150->230
        assertTrue(SILab2.function(new User("$Luka","bilo!shohgh","Luka@gmail.com"),list));
        //10->30->50->60->70.1->70.2->80->90->110->70.3->70.2->130->140->160->170->180.1->180.2->190->200->230
        assertFalse(SILab2.function(new User("Luka","testproba","luka@gmail.com"),list));
        //10->30->50->60->70.1->80->90->100->110->120->70.3->70.2->130->140->160->170->180.1->180.2->190->180.3->180.2->210->220->230
    }
    void multipleCondition (){
             RuntimeException exept;
             //True , X, X
             exept = assertThrows(RuntimeException.class, () -> SILab2.function( null,null));
             assertEquals("Mandatory information missing!",exept.getMessage());
             //False, True, X
             exept = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Luka",null,null),null));
             assertEquals("Mandatory information missing!",exept.getMessage());
             //False, False, True
             exept = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Luka","Password!",null),null));
             assertEquals("Mandatory information missing!",exept.getMessage());
             //False, False, False
             exept = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Luka","Password","Luka@gmail.com"),null));
             assertNotEquals("Mandatory information missing!",exept.getMessage());

   }
}
