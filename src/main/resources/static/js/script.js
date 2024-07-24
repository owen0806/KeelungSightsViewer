const url = 'http://localhost:8080/SightAPI?zone=';
async function fetchData(zone) {
    console.log(zone);
    const res = await fetch(url + zone);
    const data = await res.json();
    showCards(data);
}

function showCards(data) {
    let cardID = 0;
    const card_container = document.getElementById('card-container');
    card_container.innerHTML = '';

    data.forEach(element => {    
        cardID++;
        card_container.innerHTML += 
        `<div class="col-12 col-md-4 my-3">
          <div class="card">
            <div class="card-header text-center">
              <h4 class="card-title">${element.sightName}</h4>
              <div class="p-2">${element.zone}</div>
              <div class="p-2">${element.category}</div>
              <a class="btn" href="https://www.google.com/maps/search/?api=1&query=${element.sightName} ${element.address}" target="_blank">${element.address}</a>
              <a class="btn" data-bs-toggle="collapse" href="#collapse${cardID}">詳細資訊</a>
            </div>
            <div id="collapse${cardID}" class="collapse" data-bs-parent="#accordion">
              <div class="card-body">
                <img class="mx-auto d-block img-thumbnail rounded"
                  src="${element.photoURL}" />
                ${element.description}
              </div>
            </div>
          </div>
        </div>`;
    });
}