<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Payments</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Payments</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="PaymentDate (MM/dd/yyyy):"/>
                    <h:inputText id="paymentDate" value="#{payments.payments.paymentDate}" title="PaymentDate" required="true" requiredMessage="The paymentDate field is required." >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="Amount:"/>
                    <h:inputText id="amount" value="#{payments.payments.amount}" title="Amount" required="true" requiredMessage="The amount field is required." />
                    <h:outputText value="CheckNumber:"/>
                    <h:outputText value="#{payments.payments.checkNumber}" title="CheckNumber" />
                    <h:outputText value="CustomerNumber:"/>
                    <h:selectOneMenu id="customerNumber" value="#{payments.payments.customerNumber}" title="CustomerNumber" required="true" requiredMessage="The customerNumber field is required." >
                        <f:selectItems value="#{customers.customersItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{payments.edit}" value="Save">
                    <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments][payments.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{payments.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments][payments.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{payments.listSetup}" value="Show All Payments Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
