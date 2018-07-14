<c:set var="List" value="${requestScope.MISSION}" />
<c:if test="${List != null}">
    <c:if test="${not empty List}" var="check">
        <c:forEach var="item" items="${List}" varStatus="counter">
            
        </c:forEach>
    </c:if>
    <c:if test="${!check}">
        <div>No record found</div>
    </c:if>
</c:if>