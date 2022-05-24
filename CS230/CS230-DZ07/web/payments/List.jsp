<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Payments Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Payments Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Payments Items Found)<br />" rendered="#{payments.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{payments.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{payments.pagingInfo.firstItem + 1}..#{payments.pagingInfo.lastItem} of #{payments.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{payments.prev}" value="Previous #{payments.pagingInfo.batchSize}" rendered="#{payments.pagingInfo.firstItem >= payments.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{payments.next}" value="Next #{payments.pagingInfo.batchSize}" rendered="#{payments.pagingInfo.lastItem + payments.pagingInfo.batchSize <= payments.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{payments.next}" value="Remaining #{payments.pagingInfo.itemCount - payments.pagingInfo.lastItem}"
                                   rendered="#{payments.pagingInfo.lastItem < payments.pagingInfo.itemCount && payments.pagingInfo.lastItem + payments.pagingInfo.batchSize > payments.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{payments.paymentsItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PaymentDate"/>
                            </f:facet>
                            <h:outputText value="#{item.paymentDate}">
                                <f:convertDateTime pattern="MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Amount"/>
                            </f:facet>
                            <h:outputText value="#{item.amount}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CheckNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.checkNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CustomerNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.customerNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{payments.detailSetup}">
                                <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][payments.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{payments.editSetup}">
                                <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][payments.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{payments.remove}">
                                <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][payments.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{payments.createSetup}" value="New Payments"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
