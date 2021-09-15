<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">
    <html>
      <body>

        <h2>Studenti</h2>
        <table border="1">
            <tr bgcolor="blue">
                <th>Ime</th>
                <th>Prezime</th>
                <th>Starost</th>
                <th>Ocena</th>
                <th>Šifra predmeta</th>
            </tr>
            <xsl:for-each select="/studenti/student[starost>22 or ocena>5]">
                <tr bgcolor="lightblue">
                    <td>
                        <xsl:value-of select="ime" />
                    </td>
                    <td>
                        <xsl:value-of select="prezime" />
                    </td>
                    <td>
                        <xsl:value-of select="starost" />
                    </td>
                    <td>
                        <xsl:value-of select="ocena" />
                    </td>
                    <td>
                        <xsl:value-of select="sifra_predmeta" />
                    </td>
                 </tr>
            </xsl:for-each>
        </table>


        <h2>Najmlađi Student</h2>
            <xsl:for-each select="studenti/student">
                <xsl:sort select="starost" data-type="number" order="ascending"/>
                <xsl:if test="position() = 1">
                  Najmlađi Student:
                  <table border="1">
                  <tr bgcolor="blue">
                   <th>Ime</th>
                   <th>Prezime</th>
                  </tr>
                   <tr bgcolor="lightblue">
                    <td>
                        <xsl:value-of select="ime" />
                    </td>
                    <td>
                        <xsl:value-of select="prezime" />
                    </td>
                   </tr>
                  </table>           
                </xsl:if>
            </xsl:for-each>

  
        <h2>Najstariji Student</h2>
          <xsl:for-each select="studenti/student">
              <xsl:sort select="starost" data-type="number" order="ascending"/>
              <xsl:if test="position() = last()">
                Najstariji Student:
                <table border="1">
                  <tr bgcolor="blue">
                   <th>Ime</th>
                   <th>Prezime</th>
                  </tr>
                   <tr bgcolor="lightblue">
                    <td>
                        <xsl:value-of select="ime" />
                    </td>
                    <td>
                        <xsl:value-of select="prezime" />
                    </td>
                   </tr>
                </table>                   
              </xsl:if>
          </xsl:for-each>
      </body>
    </html>
</xsl:template>
</xsl:stylesheet>