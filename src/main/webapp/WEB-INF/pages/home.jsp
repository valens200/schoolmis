<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
    <title>RCA Management Portal</title>
    <link rel="stylesheet" href="../cssfile.css" type="text/css"/>
    <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<div class="home bg-no-repeat h-[100vh] w-[100%]  bg-cover bg-[black] bg-[url('https://rca.ac.rw/images/visit-to-DMM-Hehe.jpg')]">
    <div class="flex items-center h-[10%] w-[90%] mx-auto  text-white  flex-row  justify-between">
        <div class="w-[70%]">
         <h2 class="text-bold text-sm"> RCA Management system</h2>
        </div>
        <div class="flex w-[20%] justify-end flex-row items-center space-x-4">
            <a  class=" w-[30%]" href="login.php"><button class="bg-white text-black p-1 w-[100%]  hover:text-white rounded hover:bg-[#7c3aed]">Login</button></a>
        </div>
    </div>
    <div class="h-[80%]  flex justify-end items-center space-y-5  text-white font-bold flex flex-col items-center justify-center">
        <h1 class="w-[70%] text-4xl text-center">RCA Management System, All courses , <span class="text-[#462692]">managers</span>, <span class="text-[#462692]">employees</span> , <span class="text-[#462692]">Marks
        </span> management in one.</h1>
        <a class="w-[80%] flex flex-col animate-bounce justify-center items-center" href="register.php">
            <iconify-icon class="text-4xl" icon="bx:arrow-from-top"></iconify-icon>
            <button class="text-white p-2 w-[10%] mx-auto hover:text-black  rounded  hover:bg-white bg-[#7c3aed]">Register</button>
        </a>
    </div>
    <div>
        <div class="text-white">
            <p>Powered by <a href="valensniyonsenga2003@gmail.com">Valens NIYONSENGA</a></p>
        </div>
    </div>
</div>
</body>
