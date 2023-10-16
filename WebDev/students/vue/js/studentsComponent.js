studentsComponent = {
   template: ` 
               <div class="loading" v-if="loading">
                  <div class="loader"></div>
                  <p>Loading...</p>
               </div>

               <div v-else>
                  <header class="topheader">
                     <img src="img/logo.svg" width="30" alt="">
                     <span>Уфимский университет науки и технологий</span>
                  </header>
                  <div class="table">
                     <div class="caption">
                        <h1>Список студентов</h1>
                     </div>

                     <header class="header">
                        <div class="header-item">Номер студента</div>
                        <div class="header-item">ФИО студента</div>
                        <div class="header-item">Возраст студента</div>
                        <div class="header-item">Адрес студента</div>
                        <div class="header-item">Направление обучения</div>
                     </header>

                     <div class="row" v-for="student in students">
                        <div class="row-item"> {{student.id}} </div>
                        <div class="row-item"> {{student.name}} </div>
                        <div class="row-item"> {{student.age}} </div>
                        <div class="row-item"> {{student.address}} </div>
                        <div class="row-item"> {{student.direction}} </div>
                     </div>
                  </div>

                  <div class="buttons">
                     <div>
                        <button class="add-button button" v-on:click="addStudent">Добавить</button>
                     </div>
                     <div>
                        <button class="edit-button button" v-on:click="editStudent">Редактировать</button>
                     </div>
                     <div>
                        <button class="delete-button button" v-on:click="deleteStudent">Удалить</button>
                     </div>
                  </div>
               </div>`,

   data() {
      return {
         loading: true,
         students: null
      };
   },

   methods: {
      addStudent: function (event) {
         this.$router.push('/addStudent');
      },

      editStudent: function (event) {
         this.$router.push('/editStudent');
      },

      deleteStudent: function (event) {
         this.$router.push('/deleteStudent');
      }
   },

   mounted() {
      axios
         .get('http://localhost:8080/students', { mode: 'no-cors' })
         .then(response => this.students = response.data)
         .finally(() => this.loading = false)
   }
}