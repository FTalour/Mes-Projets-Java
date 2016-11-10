<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
<xsl:template match="/">
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
		xmlns:q0="http://www.leuville.com/fournisseurService/"
		xmlns:xsd="http://www.w3.org/2001/XMLSchema"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

		<soapenv:Body>
			<q0:getPrix>
				<xsl:apply-templates />
			</q0:getPrix>
		</soapenv:Body>
	</soapenv:Envelope>
</xsl:template>
<xsl:template match="code-produit">
	<xsl:element name="code-produit"> 
		<xsl:value-of select="text()" />
	</xsl:element>
</xsl:template>
</xsl:stylesheet>

