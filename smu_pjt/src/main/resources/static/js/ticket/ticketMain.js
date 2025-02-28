
const products = [
    { name: "콘서트 티켓 A", price: "₩50,000", info: "단독판매", img: "https://via.placeholder.com/150" },
    { name: "뮤지컬 티켓 B", price: "₩70,000", info: "한정판", img: "https://via.placeholder.com/150" },
    { name: "연극 티켓 C", price: "₩40,000", info: "특가", img: "https://via.placeholder.com/150" },
    { name: "페스티벌 티켓 D", price: "₩90,000", info: "VIP", img: "https://via.placeholder.com/150" },
    { name: "콘서트 티켓 E", price: "₩55,000", info: "단독판매", img: "https://via.placeholder.com/150" },
    { name: "뮤지컬 티켓 F", price: "₩75,000", info: "한정판", img: "https://via.placeholder.com/150" },
    { name: "연극 티켓 G", price: "₩45,000", info: "특가", img: "https://via.placeholder.com/150" },
    { name: "페스티벌 티켓 H", price: "₩95,000", info: "VIP", img: "https://via.placeholder.com/150" }
];

const productList = document.getElementById("product-list");
products.forEach(product => {
    const productDiv = document.createElement("div");
    productDiv.classList.add("product");
    productDiv.innerHTML = `
        <img src="${product.img}" alt="${product.name}">
        <p class="product-name">${product.name}</p>
        <p class="product-price">${product.price}</p>
        <p class="product-info">${product.info}</p>
    `;
    productList.appendChild(productDiv);
});

$(document).ready(function() {
	
	// 아이템뷰 페이지 이동 - 임시
	$('.product-item').on('click', function() {
        alert('다음 단계로 넘어갑니다.');
		window.location.href = '/ticketShop/offlineTicketView';
    });
    
});