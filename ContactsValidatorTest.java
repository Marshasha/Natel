import static org.junit.Assert.*;

import org.junit.Test;


public class ContactsValidatorTest {
	
	ContactsValidator test  = new ContactsValidator();

	@Test
	public void testPhone() {
	
		assertTrue(test.validerTel("0795643423"));
		assertFalse(test.validerTel("079564342"));
		assertFalse(test.validerTel("07956434278"));
		assertFalse(test.validerTel("0795A64342"));

	}
	
	@Test
	public void testEMail(){
		
		assertTrue(test.validerEmail("anna@gmai.com"));
		assertFalse(test.validerEmail("ann/ta@toto.ch"));
		assertFalse(test.validerEmail("anna@tartar"));
		assertFalse(test.validerEmail("anna@totoch."));
		
	}

}
