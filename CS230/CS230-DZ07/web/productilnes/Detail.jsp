<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Productilnes Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Productilnes Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="ProductLine:"/>
                    <h:outputText value="#{productilnes.productilnes.productLine}" title="ProductLine" />
                    <h:outputText value="TextDescription:"/>
                    <h:outputText value="#{productilnes.productilnes.textDescription}" title="TextDescription" />
                    <h:outputText value="HtmlDescription:"/>
                    <h:outputText value="#{productilnes.productilnes.htmlDescription}" title="HtmlDescription" />
                    <h:outputText value="Image:"/>
                    <h:outputText value="#{productilnes.productilnes.image}" title="Image" />
                    <h:outputText value="Code:"/>
                    <h:panelGroup>
                        <h:outputText value="#{productilnes.productilnes.code}"/>
                        <h:panelGroup rendered="#{productilnes.productilnes.code != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{products.detailSetup}">
                                <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes][productilnes.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes.code][products.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="productilnes"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductilnesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{products.editSetup}">
                                <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes][productilnes.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes.code][products.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="productilnes"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductilnesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{products.destroy}">
                                <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes][productilnes.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes.code][products.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="productilnes"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductilnesController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{productilnes.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes][productilnes.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{productilnes.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes][productilnes.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{productilnes.createSetup}" value="New Productilnes" />
                <br />
                <h:commandLink action="#{productilnes.listSetup}" value="Show All Productilnes Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
