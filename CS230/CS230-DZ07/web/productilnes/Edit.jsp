<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Productilnes</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Productilnes</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="ProductLine:"/>
                    <h:outputText value="#{productilnes.productilnes.productLine}" title="ProductLine" />
                    <h:outputText value="TextDescription:"/>
                    <h:inputText id="textDescription" value="#{productilnes.productilnes.textDescription}" title="TextDescription" required="true" requiredMessage="The textDescription field is required." />
                    <h:outputText value="HtmlDescription:"/>
                    <h:inputText id="htmlDescription" value="#{productilnes.productilnes.htmlDescription}" title="HtmlDescription" required="true" requiredMessage="The htmlDescription field is required." />
                    <h:outputText value="Image:"/>
                    <h:inputText id="image" value="#{productilnes.productilnes.image}" title="Image" required="true" requiredMessage="The image field is required." />
                    <h:outputText value="Code:"/>
                    <h:selectOneMenu id="code" value="#{productilnes.productilnes.code}" title="Code" required="true" requiredMessage="The code field is required." >
                        <f:selectItems value="#{products.productsItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{productilnes.edit}" value="Save">
                    <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes][productilnes.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{productilnes.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][productilnes.productilnes][productilnes.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{productilnes.listSetup}" value="Show All Productilnes Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
