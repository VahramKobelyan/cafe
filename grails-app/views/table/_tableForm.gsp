<%@ page import="cafe.User; cafe.UserRole; cafe.UserService" %>
<fieldset class="form">
    <li class="fieldcontain">
        <span id="name-label" class="name-label">Name</span>
        <g:field type="name" name="name" value="${table?.name}"/>
    </li>
    <li class="fieldcontain">
        <span id="waiter-label" class="waiter-label">Waiter</span>
        <g:select name="waiter"
                  from="${cafe.User.findAllByRole(cafe.UserRole.WAITER)}"
                  optionKey="id"
                  optionValue="username"/>
    </li>

</fieldset>
