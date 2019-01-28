<%@ page import="cafe.User; cafe.UserRole; cafe.UserService" %>
<fieldset class="form">
        %{--<cf:productlist></cf:productlist>--}%
        <p><textarea rows="100" cols="450" name="products">
            ${order?.productsInOrder as grails.converters.JSON}
        </textarea></p>

        %{--<g:hiddenField name="openDate" value="${order?.openDate}" />--}%
        <g:hiddenField name="cafeTable" value="${order?.cafeTable?.id}"/>

</fieldset>
<asset:javascript src="order.js"/>
