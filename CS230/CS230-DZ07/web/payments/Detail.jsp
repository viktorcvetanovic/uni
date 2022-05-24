<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Payments Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Payments Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="PaymentDate:"/>
                    <h:outputText value="#{payments.payments.paymentDate}" title="PaymentDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>
                    <h:outputText value="Amount:"/>
                    <h:outputText value="#{payments.payments.amount}" title="Amount" />
                    <h:outputText value="CheckNumber:"/>
                    <h:outputText value="#{payments.payments.checkNumber}" title="CheckNumber" />
                    <h:outputText value="CustomerNumber:"/>
                    <h:panelGroup>
                        <h:outputText value="#{payments.payments.customerNumber}"/>
                        <h:panelGroup rendered="#{payments.payments.customerNumber != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{customers.detailSetup}">
                                <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments][payments.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments.customerNumber][customers.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="payments"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.PaymentsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customers.editSetup}">
                                <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments][payments.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments.customerNumber][customers.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="payments"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.PaymentsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customers.destroy}">
                                <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments][payments.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments.customerNumber][customers.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="payments"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.PaymentsController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{payments.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments][payments.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{payments.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][payments.payments][payments.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{payments.createSetup}" value="New Payments" />
                <br />
                <h:commandLink action="#{payments.listSetup}" value="Show All Payments Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
