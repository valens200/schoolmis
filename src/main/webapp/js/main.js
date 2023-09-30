import {me} from "./test.js";

// console.log('Hello World', me)

// table
const dateEls = document.querySelectorAll('td[data-type="date"]')??[];
console.log('dateEls', dateEls);
dateEls?.forEach(el => {
    console.log(el.textContent);
    const newDate = new Date(el.textContent).toLocaleDateString();
    console.log(newDate);
    el.textContent = newDate;
})
