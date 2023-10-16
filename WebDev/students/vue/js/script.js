const routes = [
   { path: "/", component: studentsComponent },
   { path: "/students", component: studentsComponent },
   { path: "/addStudent", component: addStudentComponent },
   { path: "/deleteStudent", component: deleteStudentComponent },
   { path: "/editStudent", component: editStudentComponent }
]

const router = new VueRouter.createRouter({
   history: VueRouter.createWebHashHistory(),
   routes
})

const app = Vue.createApp({})
app.use(router)
app.mount('#app')