deleteStudentComponent = {
   template: `
      <div>
         <header class="topheader">
            <img src="img/logo.svg" width="30" alt="">
            <span>Уфимский университет науки и технологий</span>
         </header>

         <div class="delete-form table">
            <div class="caption">
               <h1>Форма удаления студента</h1>
            </div>

            <section class="form">
               <div class="form-block">
                  <div class="form-block-option">
                     <p>Номер студента</p>
                     <input type="text" v-model.trim="student.id" placeholder="НОМЕР">
                  </div>
               </div>
            </section>
         </div>

         <div class="buttons">
            <div>
               <button class="save-button button" v-on:click="deleteStudent">Сохранить</button>
            </div>
            <div>
               <button class="cancel-button button" v-on:click="cancel">Отмена</button>
            </div>
         </div>
      </div>
   `,

   data() {
      return {
         student: {
            id: null
         }
      }
   },

   methods: {
      deleteStudent: function (event) {
         if (confirm('Вы уверены, что хотите удалить данные о студенте?')) {
            axios.delete('http://localhost:8080/students/' + this.student.id)
               .then(response => {
                  console.log('Student deleted');
                  this.$router.push('/students');
               })
               .catch(error => {
                  alert(error);
               });
         }
      },

      cancel: function (event) {
         this.$router.push('/students');
      }
   }
}