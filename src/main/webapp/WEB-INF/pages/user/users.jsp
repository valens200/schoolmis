<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
    <title>Users List</title>
</head>
<body>
<jsp:include page="../../components/headeradmin.jsp">
    <jsp:param value="users" name="title"/>
</jsp:include>
<div class="flex flex-col w-full gap-y-4">
    <div class="flex w-full items-center justify-between">
        <h1 class="font-semibold text-xl text-center">Registered users</h1>
        <div class="flex flex-row  gap-4">
            <a href="generate_users_report.php" class="bg-violet-800 flex gap-4 justify-between hover:bg-violet-900 text-white  font-bold py-2 px-3 rounded">
                <i class="bx text-xl font-bold bx-download"></i>  Download excel
            </a>
            <a href="createuser.php" class="bg-violet-800 hover:bg-violet-900 text-white gap-x-3 font-bold py-2 px-4 rounded">
                <i class="bx bx-plus"></i>  Add User
            </a>
        </div>
    </div>
    <div class="w-full flex overflow-x-auto">
        <table class="min-w-[500px]">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="usr" varStatus="usrstatus">
                <tr>
                    <td>${usr.id}</td>
                    <td>${usr.fullName}</td>
                    <td>${usr.email}</td>
                    <td>${usr.userRole.getRoleDescription()}</td>
                    <td class="buttons flex space-x-4 justify-end">
                        <button id="openModalBtn">
                            <i class='bx bxs-edit text-2xl'></i>
                        </button>
<%--                        <a href="delete.php?id=${usr.id}&page=deleteUser">--%>
<%--                            <button type="submit"><i class='bx bxs-trash text-2xl'></i></button>--%>
<%--                        </a>--%>
                        <div id="myModal" class="modal">
                            <div class="modal-content">
                                <span class="close">&times;</span>
                                <p class=" mt-8 text-lg font-semibold">
                                    What do you want to do with this user?
                                </p>
                                <div class="flex flex-row gap-4 mt-8 justify-end">
                                    <a class="flex " href="delete.php?id=${usr.id}&page=deleteUser">
                                        <button type="submit" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
                                            Delete
                                        </button>
                                    </a>
                                    <a href="update.php?id=${usr.id}&page=updateUser">
                                    <button type="button" class="bg-green-500 cancel flex hover:bg-green-700 text-white font-bold py-2 px-4 rounded">
                                        Update
                                    </button>
                                    </a>
                                </div>
                            </div>
                        </div>
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