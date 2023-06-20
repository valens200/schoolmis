<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../components/headeradmin.jsp">
  <jsp:param
          name="title" value="Update Employee"/>
</jsp:include>
<form
        class="flex h-fit flex-col max-w-[600px] p-4 w-full shadow-lg mt-7 p-5 w-[20%] gap-y-4"
        method="POST"
        action="update.php?id=${id}&page=updateEmployee"
>
  <c:if test="${message != null}">
    <span class="text-yellow-700"> ${message}</span>
  </c:if>
  <h2 class=" text-2xl ">Employee Updating</h2>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="FirstName"> FirstName</label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="firstName"
            type="text"
            value="${employee.firstName}"
            required />
  </div>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="LastName"> LastName </label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="lastName"
            type="text"
            value="${employee.lastName}"
            required />
  </div>
  <%--  <div class="flex flex-col gap-y-1">--%>
  <%--    <label class=" px-2" for="email">Email </label>--%>
  <%--    <input--%>
  <%--            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"--%>
  <%--            name="email"--%>
  <%--            type="text"--%>
  <%--            value="${manager.email}"--%>
  <%--            required />--%>
  <%--  </div>--%>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="phoneNumber"> phoneNumber</label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="phoneNumber"
            type="text"
            value="${employee.phoneNumber}"
            required />
  </div>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="dateOfBirth"> dateOfBirth</label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="dob"
            value="${employee.dateOfBirth}"
            type="date"
            required />
  </div>
  <button
          class="p-3 mt-1 px-9 rounded-md w-fit bg-violet-800 hover:bg-violet-900 duration-300 uppercase  text-white text-sm"
          type="submit"
  >
    Update Employee
  </button>
</form>
<%@ include file="../../components/footer.jsp" %>