<#import "parts/common.ftl" as c>
<@c.page>
    User Edit
    <form method="post" action="/user">
        <label>Username:
            <input type="text" name="username" value="${user.username}"/>
        </label>
        <#list roles as role>
            <div>
                <label>
                    ${role}
                    <input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")} >
                </label>
            </div>
        </#list>
        <input type="hidden" name="userId" value="${user.id}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Submit</button>
    </form>
</@c.page>