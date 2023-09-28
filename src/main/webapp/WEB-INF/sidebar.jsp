<div class=" w-[250px] border-r-[1px] text-black md:flex justify-between hidden flex-col p-4 py-9 bg-primary fixed top-0 left-0 h-screen">
    <div class="flex w-full flex-col">
        <a href=dashboard.php" class="flex w-fit items-center">
            <img
                    class=" rounded-full object-cover"
                    src="images/rcalogo.png"
                    width="50"
                    height="50"
            />
            <h1 class="text-2xl font-bold ml-2">RCA SMIS</h1>
        </a>
        <div class="flex flex-col mt-24 gap-y-3">
            <a
                    href="dashboard.php"
                    class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
            >
                <i class='bx bx-home text-2xl'></i>
                <h1 class="ml-2">Home</h1>
            </a>
            <a
                    href="listcourse.php"
                    class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
            >
                <i class='bx bxs-graduation text-2xl'></i>
                <h1 class="ml-2">Courses</h1>
            </a>
            <%--                        show user if role of auth user is adminÎ--%>
            <c:if test="${authenticatedUser.userRole.toString() eq 'ADMIN'}">
                <a
                        href="listuser.php"
                        class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
                >
                    <i class='bx bx-group text-2xl'></i>
                    <h1 class="ml-2">Users</h1>
                </a>
            </c:if>
            <a
                    href="students.php"
                    class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
            >
                <i class='bx bx-group text-2xl'></i>
                <h1 class="ml-2">Students</h1>
            </a>
            <c:if test="${authenticatedUser.userRole.toString() != 'GUEST'}">
                <a
                        href="marks.php?page=marks&action=list"
                        class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
                >
                    <i class='bx bx-group text-2xl'></i>
                    <h1 class="ml-2">Marks</h1>
                </a>
            </c:if>
            <a
                    href="instructors.php?page=instructors&action=list"
                    class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
            >
                <i class='bx bx-group text-2xl'></i>
                <h1 class="ml-2">Intructors</h1>
            </a>
            <a
                    href="employees.php?page=employees&action=list"
                    class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
            >
                <i class='bx bx-group text-2xl'></i>
                <h1 class="ml-2">Employees</h1>
            </a>
            <a
                    href="managers.php?page=managers&action=list"
                    class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
            >
                <i class='bx bx-group text-2xl'></i>
                <h1 class="ml-2">Managers</h1>
            </a>
        </div>
    </div>
    <div class="flex flex-col gap-y-3 w-full">
        <a
                href="logout.php"
                class="flex items-center rounded-md py-2 px-3 hover:bg-blue-500/30 hover:text-blue-500 duration-200"
        >
            <i class="bx bx-log-out text-lg"></i>
            <h1 class="ml-2">Logout</h1>
        </a>
    </div>
</div>