
module xyz.meistertobias.soap.client {
	
	requires xyz.meistertobias.soap;
	requires java.xml.ws;
	
	opens xyz.meistertobias.soap.client.gen.calc to java.xml.ws, java.xml.bind;
	opens xyz.meistertobias.soap.client.gen.user to java.xml.ws, java.xml.bind;
}
