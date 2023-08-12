
    document.addEventListener("DOMContentLoaded", () => {
    
    
    // Get the list element and the todo list from local storage
    let list = document.querySelector("#userList")
    let task = localStorage.getItem("task")
  
    // Get the toasts and the add button elements
    const error = document.querySelectorAll("#liveToast")
    const successCoast = document.querySelectorAll("#successCoast")
    const btnadd = document.querySelector("#liveToastBtn")
  
    // If there is a todo list in local storage, set the list element's inner HTML to it
    if (task) {
      list.innerHTML = JSON.parse(task)
    }
  
    // Function to create a new list item
    function newElement() {
      const li = document.createElement("li")
      let task = document.querySelector("#task").value.trim()
  
      // If the task is empty, show the "Please enter a task" toast and return
      if (!task) {
        $(error).toast("show")
        return
      }
  
      // Clear the input field
      document.querySelector("#task").value = ""
  
      // Set the text content of the list item
      li.textContent = task
  
      // Add an event listener to toggle the "checked" class on click and update the todo list in local storage
      li.addEventListener("click", () => {
        if (li.classList.contains("checked")) li.classList.remove("checked")
        else li.classList.add("checked")
        localStorage.setItem("task", JSON.stringify(list.innerHTML))
      });
  
      // Create a delete button and add an event listener to remove the list item
      const removeSpan = document.createElement("span");
      removeSpan.innerHTML = "&times;"
      removeSpan.classList.add("close")
      removeSpan.addEventListener("click", () => {
        removeElement(li)
      });
  
      // Append the delete button to the list item and the list item to the list
      li.appendChild(removeSpan)
      list.appendChild(li)
  
      // Show the "Task added to list" toast
      $(successCoast).toast("show")
  
      // Update the todo list in local storage
      localStorage.setItem("task", JSON.stringify(list.innerHTML))
    }
  
    // Add an event listener to the input field to create a new list item on enter key press
    document.querySelector("#task").addEventListener("keypress", (event) => {
      if (event.key === "Enter") newElement()
    })

    // Add an event listener to each list item to toggle the "checked" class on click and update the todo list in local storage
    document.querySelectorAll("#userList li").forEach((item) => {
      item.addEventListener("click", () => {
        if (item.classList.contains("checked")) item.classList.remove("checked")
        else item.classList.add("checked")
        localStorage.setItem("task", JSON.stringify(list.innerHTML))
      })
    })

    // Add an event listener to each delete button to remove the corresponding list item and update the todo list in local storage
    document.querySelectorAll("#userList span").forEach((item) => {
      let li = item.parentNode;
      item.addEventListener("click", () => {
        removeElement(li);
      })
    })
  
    // Add an event listener to the add button to create a new list item
    btnadd.addEventListener("click", newElement)
  
    // Function to remove a list item and update the todo list in local storage
    function removeElement(li) {
      li.remove()
      localStorage.setItem("task", JSON.stringify(list.innerHTML))
    }
  })

