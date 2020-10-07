<#import "parts/common.ftl" as c>
<@c.page>
    User List
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Roles</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
