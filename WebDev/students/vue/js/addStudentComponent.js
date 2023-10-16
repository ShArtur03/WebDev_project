addStudentComponent = {
   template: `
            <div>
               <header class="topheader">
                  <img src="img/logo.svg" width="30" alt="">
                  <span>Уфимский университет науки и технологий</span>
               </header>

               <div class="add-form table">
                  <div class="caption">
                     <h1>Форма добавления студента</h1>
                  </div>

                  <section class="form">
                     <div class="form-block">
                        <div class="form-block-option">
                           <p>Номер студента:</p>
                           <input type="text" v-model.trim="student.id" placeholder="НОМЕР">
                        </div>
                        <div class="form-block-option">
                           <p>Имя студента:</p>
                           <input type="text" v-model.trim="student.name" placeholder="ИМЯ">
                        </div>
                        <div class="form-block-option">
                           <p>Возраст студента:</p>
                           <input type="text" v-model.trim="student.age" placeholder="ВОЗРАСТ">
                        </div>
                        <div class="form-block-option">
                           <p>Адрес студента:</p>
                           <input type="text" v-model.trim="student.address" placeholder="АДРЕС">
                        </div>
                        <div class="form-block-option">
                           <p>Направление обучения студента:</p>
                           <input type="text" v-model.trim="student.direction" placeholder="НАПРАВЛЕНИЕ">
                        </div>

                     </div>
                  </section>
               </div>

               <div class="buttons">
                  <div>
                     <button class="save-button button" v-on:click="addStudent">Сохранить</button>
                  </div>
                  <div>
                     <button class="cancel-button button" v-on:click="cancel">Отмена</button>
                  </div>
               </div>
            </div>`,

   data() {
      return {
         student: {
            id: null,
            name: null,
            age: null,
            address: null,
            direction: null
         }
      }
   },

   methods: {
      addStudent: function (event) {
         console.log(JSON.stringify(this.student));
         axios.post('http://localhost:8080/students',
            JSON.stringify(this.student), {
            headers: {
               'Content-Type': 'application/json; charset=utf-8'
            }
         })
            .then(response => {
               console.log("student added");
               this.$router.push('/students');
            })
            .catch(error => {
               alert(error);
            });
      },
      cancel: function (event) {
         this.$router.push('/students');
      }
   }
}