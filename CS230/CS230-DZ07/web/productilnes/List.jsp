<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Productilnes Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Productilnes Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Productilnes Items Found)<br />" rendered="#{productilnes.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{productilnes.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{productilnes.pagingInfo.firstItem + 1}..#{productilnes.pagingInfo.lastItem} of #{productilnes.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{productilnes.prev}" value="Previous #{productilnes.pagingInfo.batchSize}" rendered="#{productilnes.pagingInfo.firstItem >= productilnes.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{productilnes.next}" value="Next #{productilnes.pagingInfo.batchSize}" rendered="#{productilnes.pagingInfo.lastItem + productilnes.pagingInfo.batchSize <= productilnes.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{productilnes.next}" value="Remaining #{productilnes.pagingInfo.itemCount - productilnes.pagingInfo.lastItem}"
                                   rendered="#{productilnes.pagingInfo.lastItem < productilnes.pagingInfo.itemCount && productilnes.pagingInfo.lastItem + productilnes.pagingInfo.batchSize > productilnes.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{productilnes.productilnesItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="ProductLine"/>
                            </f:facet>
                            <h:outputText value="#{item.productLine}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="TextDescription"/>
                            </f:facet>
                            <h:outputText value="#{item.textDescription}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="HtmlDescription"/>
                            </f:facet>
                            <h:outputText value="#{item.htmlDescription}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Image"/>
                            </f:facet>
                            <h:outputText value="#{item.image}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Code"/>
                            </f:facet>
                            <h:outputText value="#{item.code}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{productilnes.detailSetup}">
                                <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][productilnes.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{productilnes.editSetup}">
                                <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][productilnes.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{productilnes.remove}">
                                <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][productilnes.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{productilnes.createSetup}" value="New Productilnes"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
