console.log("Welcome to the Community Portal");
window.addEventListener("load", () => {
  alert("Page fully loaded!");
});


const eventName = "Community Potluck";
const eventDate = "2025-06-10";
let availableSeats = 30;
console.log(`${eventName} is on ${eventDate}. Seats: ${availableSeats}`);


const events = [
  { name: "Music Night", date: "2025-06-10", category: "music", seats: 10 },
  { name: "Art Show", date: "2024-01-01", category: "art", seats: 0 },
  { name: "Coding Bootcamp", date: "2025-08-12", category: "tech", seats: 25 }
];

events.forEach(event => {
  const upcoming = new Date(event.date) > new Date();
  if (upcoming && event.seats > 0) {
    console.log(`Upcoming: ${event.name}`);
  }
});

function registerUserForEvent(event) {
  try {
    if (event.seats <= 0) throw new Error("Event is full!");
    event.seats--;
    console.log(`Registered for ${event.name}. Seats left: ${event.seats}`);
  } catch (err) {
    console.error(err.message);
  }
}

function addEvent(name, category, seats) {
  events.push({ name, category, seats });
}

function filterEventsByCategory(category) {
  return events.filter(e => e.category === category);
}

function createCategoryTracker(category) {
  let total = 0;
  return () => {
    total++;
    console.log(`Registrations for ${category}: ${total}`);
  };
}

const musicTracker = createCategoryTracker("music");

function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const yoga = new Event("Yoga Class", "2025-07-01", 20);
console.log(Object.entries(yoga));

events.push({ name: "Baking Workshop", category: "cooking", seats: 12 });

const musicEvents = events.filter(e => e.category === "music");
const formattedEvents = events.map(e => `${e.name} on ${e.date}`);
console.log(formattedEvents);

const container = document.querySelector("#eventsSection");
function renderEvent(event) {
  const div = document.createElement("div");
  div.className = "eventCard";
  div.innerHTML = `<h3>${event.name}</h3><p>${event.date}</p>`;
  container.appendChild(div);
}
events.forEach(renderEvent);

document.querySelector("#categoryFilter")?.addEventListener("change", e => {
  const filtered = filterEventsByCategory(e.target.value);
  container.innerHTML = "";
  filtered.forEach(renderEvent);
});

document.addEventListener("keydown", e => {
  if (e.key === "Enter") {
    console.log("Search triggered (Enter key)");
  }
});

fetch("assets/events.json")
  .then(res => res.json())
  .then(data => console.log("Mock Events:", data))
  .catch(err => console.error("Fetch error:", err));

async function loadEvents() {
  try {
    document.body.classList.add("loading");
    const res = await fetch("assets/events.json");
    const data = await res.json();
    console.log("Loaded events (async/await):", data);
  } finally {
    document.body.classList.remove("loading");
  }
}
loadEvents();

function register({ name, date }, user = "Guest") {
  console.log(`${user} registered for ${name} on ${date}`);
}

const [first, ...rest] = events;
const clonedEvents = [...events];

document.querySelector("form")?.addEventListener("submit", e => {
  e.preventDefault();
  const form = e.target;
  const name = form.elements["name"]?.value;
  const email = form.elements["email"]?.value;
  const event = form.elements["preferredEvent"]?.value;
  if (!name || !email || !event) {
    alert("Fill all fields");
    return;
  }
  console.log({ name, email, event });
});

async function submitRegistration(data) {
  try {
    const res = await fetch("https://example.com/api/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    });
    const result = await res.json();
    setTimeout(() => alert("Registration successful!"), 1000);
  } catch {
    alert("Failed to register");
  }
}

console.log("Debug: Form ready, awaiting submit...");

$(document).ready(() => {
  $("#registerBtn").click(() => {
    alert("Registered via jQuery!");
  });
  $(".eventCard").fadeIn();
  console.log("jQuery: Consider React or Vue for dynamic apps.");
});
