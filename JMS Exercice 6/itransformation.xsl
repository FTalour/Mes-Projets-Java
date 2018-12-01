<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XML/Transform"
	xmlns:S="http://schemas.xml.org/soap/envelope/">
<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
<xml:strip-space element="*"/>
<xsl:template match="/">
	<xsl:apply-templates />
</xsl:template>
<xsl:template match="getPrixResponse/prix">
	<xsl:element name="prix"> 
		<xsl:value-of select="text()" />
	</xsl:element>
</xsl:template>
</xsl:stylesheet>
