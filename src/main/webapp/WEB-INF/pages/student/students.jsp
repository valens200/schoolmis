<?xml version="1.0" encoding="UTF-8" ?>
<%
  // Check if there is an authenticated user (you need to define this condition)
  boolean isAuthenticated = request.getSession().getAttribute("authenticatedUser") != null;

  if (!isAuthenticated) {
    System.out.println("User is not authenticated ⛔️");
    // If not authenticated, redirect to the login page
    response.sendRedirect(request.getContextPath() + "/login.php");
  } else {
    System.out.println("User is authenticated ✅");
  }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
  <title>Students List</title>
</head>
<body>
<jsp:include page="../../components/headeradmin.jsp">
  <jsp:param value="users" name="title"/>
</jsp:include>
<div class="flex flex-col w-full gap-y-4">
  <jsp:include page="../../components/search.jsp"></jsp:include>
  <div class="flex w-full items-center justify-between">
    <h1 class="font-semibold text-xl text-center">Registered students</h1>
    <div class="flex flex-row  gap-4">
      <a href="generate_students_report.php" class="bg-violet-800 flex gap-4 justify-between hover:bg-violet-900 text-white  font-bold py-2 px-3 rounded">
        <i class="bx text-xl font-bold bx-download"></i>  Download excel
      </a>
    <a href="createstudent.php?page=createStudent" class="bg-violet-800 hover:bg-violet-900 text-white gap-x-3 font-bold py-2 px-4 rounded">
      <i class="bx bx-plus"></i>  Add Student
    </a>
    </div>
  </div>
  <div class="w-full flex overflow-x-auto">
    <table class="min-w-[500px]">
      <thead>
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone Number</th>
        <th>dateOfBirth</th>
<%--        <th>isInternational</th>--%>
<%--        <th>isPartTime</th>--%>
<%--        <th>isRepeating</th>--%>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${students}" var="usr" varStatus="usrstatus">
        <tr>
          <td>${usr.id}</td>
          <td>${usr.firstName}</td>
          <td>${usr.lastName}</td>
          <td>${usr.phoneNumber}</td>
          <td data-type="date">${usr.dateOfBirth}</td>
<%--          <td>false</td>--%>
<%--          <td>false</td>--%>
<%--          <td>false</td>--%>
          <td class="buttons flex space-x-4 justify-end">
            <a href="update.php?id=${usr.id}&page=updateStudent">
              <button type="submit"><i class='bx bxs-edit text-2xl'></i></button>
            </a>
            <a href="delete.php?id=${usr.id}&page=deleteStudent">
              <button type="submit"><i class='bx bxs-trash text-2xl'></i></button>
            </a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</div>
</div>
</div>
</body>
<%--<%@ include file="../footer.jsp" %>--%>