<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="venda">
        <html>
            <body>
                <h1>Venda</h1>
                <strong>Forma de pagamento</strong>:
                <em>
                    <xsl:value-of select="formaDePagamento"/>
                </em>
                <xsl:apply-templates select="produtos"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="produto">
        <li>
            <ul>
                <li>
                    <xsl:value-of select="nome"/>
                </li>
                <li>R$
                    <xsl:value-of select="preco"/>
                </li>
            </ul>
        </li>
    </xsl:template>

    <xsl:template match="produtos">
        <div>
            <strong>Produtos</strong>
            <ol>
                <xsl:apply-templates select="produto"/>
            </ol>
        </div>
    </xsl:template>

</xsl:stylesheet>