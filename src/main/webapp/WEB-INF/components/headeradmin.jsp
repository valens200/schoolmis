
<%@include file="mainheader.jsp"%>
<%
    // Check if there is an authenticated user (you need to define this condition)
    boolean isAuthenticated = request.getSession().getAttribute("authenticatedUser") != null;

    if (!isAuthenticated) {
        System.out.println("User is not authenticated ⛔️");
        // If not authenticated, redirect to the login page
        String loginPageURL = request.getContextPath() + "/login.php";
        System.out.println("Redirecting to: " + loginPageURL);
        response.sendRedirect( "/login.jsp");
    } else {
        System.out.println("User is authenticated ✅");
    }
%>

<div id="flex  w-full">
    <%@ include file="../sidebar.jsp" %>
    <div class="flex flex-col w-full md:pl-[250px] min-h-screen">
        <div class="flex bg-white w-full justify-between p-4 border-b-[1px] sticky top-0">
            <div class="flex w-full max-w-[400px] py-2 px-3 border-2 rounded-md">
                <i class='bx bx-search text-2xl'></i>
                <input type="text" class="w-full outline-none px-2" placeholder="Search...">
            </div>
            <div>
                <p>${responseMessage}</p>
            </div>
            <div class="flex gap-x-4 items-center">
                <i class='bx bxs-bell text-2xl'></i>
                <div class="flex gap-x-2 items-center">
                    <i class="bx bxs-user-circle text-4xl"></i>
                    <span class="flex items-center cursor-pointer">
                        <c:out value="${authenticatedUser.username}"/>
                        <i class='bx bx-chevron-down text-2xl'></i>
                    </span>
                </div>
            </div>
        </div>
        <div class="flex flex-col w-full h-full p-3">
